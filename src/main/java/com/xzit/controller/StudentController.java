package com.xzit.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.Classinfo;
import com.xzit.entity.Student;
import com.xzit.entity.StudentExample;
import com.xzit.service.ClassinfoService;
import com.xzit.service.StudentService;
import com.xzit.until.DataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caochengcheng on 2018/4/9.
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassinfoService classinfoService;

    @RequestMapping(value = "/cardnoentry.action")
    public ModelAndView cardnoentry()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student/cardnoentry");
        return mv;
    }
    @RequestMapping(value = "/goodsentry.action")
    public ModelAndView goodsentry()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student/goodsentry");
        return mv;
    }
    @RequestMapping(value = "/student.action")
    public ModelAndView student()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student/student");
        return mv;
    }
    @RequestMapping(value = "/personinfo.action")
    public ModelAndView personinfo()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student/personinfo");
        return mv;
    }

    //根据学号或卡号查询某个学生信息
    @RequestMapping(value = "/selectStudent.action")
    @ResponseBody
    public Student selectStudent(Student s)throws Exception{
        Student student;
        student = studentService.selectBySno(s.getSno());
        if (student.getBuilding()!=null&&student.getDormitory()!=null){
            student.setBandd(student.getBuilding().getBuildingno()+student.getDormitory().getDormitoryno());
        }
        return student;
    }

    @RequestMapping(value = "/selectStudentByExample.action")
    @ResponseBody
    public DataGrid<Student> selectStudentByExample(Student s,int campusid,int academyid,Integer page, Integer rows)throws Exception{

        List<Classinfo> classinfos = classinfoService.selectClassinfoByAcademyidAndCampusid(campusid,academyid);
        List<Integer> classids = new ArrayList<Integer>();
        for (Classinfo c:classinfos){
            classids.add(c.getClassid());
        }
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteriaStudent = studentExample.createCriteria();
        if (s.getSno()!=null && s.getSno()!="") criteriaStudent.andSnoLike("%"+s.getSno()+"%");
        if (s.getCardno()!=null && s.getCardno()!="") criteriaStudent.andCardnoLike("%"+s.getCardno()+"%");
        if (s.getSname()!=null && s.getSname()!="") criteriaStudent.andSnameLike("%"+s.getSname()+"%");
        if (s.getSsex()!=null && s.getSsex()!="") criteriaStudent.andSsexLike("%"+s.getSsex()+"%");
        if (s.getSphoneno()!=null && s.getSphoneno()!="") criteriaStudent.andSphonenoLike("%"+s.getSphoneno()+"%");
        if (s.getHomeadress()!=null && s.getHomeadress()!="") criteriaStudent.andHomeadressLike("%"+s.getHomeadress()+"%");
        if (s.getClassid()!=null){
            criteriaStudent.andClassidEqualTo(s.getClassid());
        }else {
            if (classids.size()>0) criteriaStudent.andClassidIn(classids);
            else criteriaStudent.andClassidEqualTo(0);
        }
        if (s.getBuildingid()!=null)criteriaStudent.andBuildingidEqualTo(s.getBuildingid());
        if (s.getDormitoryid()!=null)criteriaStudent.andDormitoryidEqualTo(s.getDormitoryid());
        if (s.getBedno()!=null )criteriaStudent.andBednoEqualTo(s.getBedno());
        PageInfo<Student> studentPageInfo = studentService.selectByExample(studentExample,page,rows);
        DataGrid<Student> dataGrid = new DataGrid<Student>();
        dataGrid.setTotal(studentPageInfo.getTotal());
        dataGrid.setRows(studentPageInfo.getList());
        return dataGrid;
    }

    @RequestMapping(value = "/updateStudentByPrimaryKeySelective.action")
    @ResponseBody
    public void updateStudentByPrimaryKeySelective(Student student, HttpServletResponse response)throws Exception{
        String msg="异常";
        int state=0;
        if (student.getSid()!=null){
            //查询床位号是否重复
            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andBednoEqualTo(student.getBedno());
            criteria.andBuildingidEqualTo(student.getBuildingid());
            criteria.andDormitoryidEqualTo(student.getDormitoryid());
            Student student1 = studentService.selectByExample(studentExample);
            if (student1!=null){
                //床位有人，状态置2
                state = 2;
            }else {
                try {
                    state = studentService.updateByPrimaryKeySelective(student);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (state==0) msg = "更新失败！学生校园卡号重复";
            else if (state==2) msg = "更新失败！该宿舍床位号重复";
            else msg="更新成功";
        }else msg="更新失败，请填写数据";
        JSONObject obj = new JSONObject();
        obj.put("success",true);
        obj.put("msg",msg);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(obj.toString());
    }

}
