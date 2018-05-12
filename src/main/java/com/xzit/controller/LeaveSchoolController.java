package com.xzit.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.Leaveschool;
import com.xzit.entity.LeaveschoolExample;
import com.xzit.entity.Student;
import com.xzit.service.LeaveSchoolService;
import com.xzit.until.DataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by caochengcheng on 2018/5/9.
 */
@Controller
public class LeaveSchoolController {

    @Autowired
    private LeaveSchoolService leaveSchoolService;

    @RequestMapping(value = "/leaveschool.action")
    public ModelAndView leaveschool()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("leaveschool/leaveschool");
        return mv;
    }
    @RequestMapping(value = "/lookleaveschool.action")
    public ModelAndView lookleaveschool()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("leaveschool/lookleaveschool");
        return mv;
    }

    //查询所有的离校信息
    @RequestMapping(value = "selectAllLeaveSchool.action")
    @ResponseBody
    public DataGrid<Leaveschool> selectAllLeaveSchool(Integer page, Integer rows, HttpSession session)throws Exception{
        String role = (String) session.getAttribute("role");
        String number = (String) session.getAttribute("number");
        PageInfo<Leaveschool> pageInfo = leaveSchoolService.selectByExample(role,number,page,rows);
        DataGrid<Leaveschool> dataGrid = new DataGrid<Leaveschool>();
        dataGrid.setRows(pageInfo.getList());
        dataGrid.setTotal(pageInfo.getTotal());
        return dataGrid;
    }

    //查询有条件的离校信息
    @RequestMapping(value = "selectLeaveSchool.action")
    @ResponseBody
    public DataGrid<Leaveschool> selectLeaveSchool(Student student,String leavestarttime, String leaveendtime,
                                                   String backstarttime, String backendtime,String notbackschool,
                                                   Integer timesort,Integer page, Integer rows)throws Exception{

        PageInfo<Leaveschool> pageInfo = leaveSchoolService.selectLeaveSchool(student,leavestarttime,leaveendtime,backstarttime,backendtime,notbackschool,timesort,page,rows);
        DataGrid<Leaveschool> dataGrid = new DataGrid<Leaveschool>();
        dataGrid.setRows(pageInfo.getList());
        dataGrid.setTotal(pageInfo.getTotal());
        return dataGrid;
    }
    //添加离校信息
    @RequestMapping(value = "leaveSchool.action")
    @ResponseBody
    public void leaveSchool(String sno,String remark,HttpServletResponse response)throws Exception{
        String msg = leaveSchoolService.addLeaveSchool(sno,remark);
        JSONObject obj = new JSONObject();
        obj.put("success",true);
        obj.put("msg",msg);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(obj.toString());
    }
    //添加返校信息
    @RequestMapping(value = "backSchool.action")
    @ResponseBody
    public void backSchool(String sno,String remark,HttpServletResponse response)throws Exception{
        String msg = leaveSchoolService.addBackSchool(sno,remark);
        JSONObject obj = new JSONObject();
        obj.put("success",true);
        obj.put("msg",msg);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(obj.toString());
    }
    @RequestMapping(value = "delLeaveSchool.action")
    @ResponseBody
    public void  delAccess(String temID,HttpServletResponse response)throws Exception{
        String msg=leaveSchoolService.delLeaveSchool(temID);
        JSONObject obj = new JSONObject();
        obj.put("success",true);
        obj.put("msg",msg);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(obj.toString());
    }
}
