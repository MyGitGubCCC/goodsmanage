package com.xzit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.*;
import com.xzit.mapper.AuntMapper;
import com.xzit.mapper.LeaveschoolMapper;
import com.xzit.mapper.StudentMapper;
import com.xzit.service.LeaveSchoolService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by caochengcheng on 2018/5/9.
 */
@Service
public class LeaveSchoolServiceImpl implements LeaveSchoolService{
    @Autowired
    private LeaveschoolMapper leaveschoolMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private AuntMapper auntMapper;
    public PageInfo<Leaveschool> selectByExample(String role,String number,Integer pageNo, Integer pageSize) throws Exception {
        LeaveschoolExample leaveschoolExample = new LeaveschoolExample();
        LeaveschoolExample.Criteria leaveschoolExampleCriteria = leaveschoolExample.createCriteria();
        Aunt aunt;
        List<Integer> sids = new ArrayList<Integer>();
        sids.add(0);
        //如果是宿管的话，查出他的所属楼号，然后找出该楼号对性的离校情况
        if (role=="宿管"){
           aunt = auntMapper.selectAuntByAuntno(number);
            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria studentExampleCriteria = studentExample.createCriteria();
            if (aunt.getBuildingid()!=null)studentExampleCriteria.andBuildingidEqualTo(aunt.getBuildingid());
            List<Student> students = studentMapper.selectByExample(studentExample);
            if (students!=null){
                for (Student s:students){
                    sids.add(s.getSid());
                }
            }
            leaveschoolExampleCriteria.andSidIn(sids);
        }

        leaveschoolExample.setOrderByClause("leaveschoolid desc");
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        List<Leaveschool> list = leaveschoolMapper.selectByExample(leaveschoolExample);
        PageInfo<Leaveschool> pageInfo = new PageInfo<Leaveschool>(list);
        return pageInfo;
    }

    public String addLeaveSchool(String sno,String remark) {
        String msg ="未知错误";
        Leaveschool leaveschool;
        leaveschool = leaveschoolMapper.selectLastLeavesSchoolBySno(sno);
        if (leaveschool==null || leaveschool.getBacktime()!=null){
            //加入离校信息
            //加入离校校时间
            Date day=new Date();
            /*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.format(day);*/
            Leaveschool addleaveschool = new Leaveschool();
            if (remark!=null && remark !="")addleaveschool.setRemark("离校备注："+remark);
            addleaveschool.setLeavetime(day);
            Student student = studentMapper.selectBySno(sno);
            addleaveschool.setSid(student.getSid());
            try {
                if (leaveschoolMapper.insertSelective(addleaveschool)==1){
                    msg="已成功离校！";
                }else msg="离校失败";
            }catch (Exception e){
                e.printStackTrace();
                msg="离校插入失败";
            }
        }else {
            //返回一个信息提示先返校
            Date day=leaveschool.getLeavetime();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String day1 = df.format(day);
            msg = "您上次离校时间为"+day1+"，请先进行返校操作，若您之前忘记操作，请备注说明！";
        }
        return msg;
    }

    public String addBackSchool(String sno, String remark) {
        String msg ="未知错误";
        Leaveschool leaveschool;
        leaveschool = leaveschoolMapper.selectLastLeavesSchoolBySno(sno);
        if (leaveschool!=null && leaveschool.getBacktime()==null){
            //加入返校信息
            //加入返校时间
            Date day=new Date();
            /*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.format(day);*/
            if (remark!=null && remark !="")leaveschool.setRemark(leaveschool.getRemark()+" 返校备注："+remark);
            leaveschool.setBacktime(day);
            try {
                if (leaveschoolMapper.updateByPrimaryKey(leaveschool)==1){
                    msg="已成功返校！";
                }else msg="返校失败";
            }catch (Exception e){
                e.printStackTrace();
                msg="离校插入失败";
            }
        }else {
            //返回一个信息提示先返校
            msg = "您还未离校，不需要进行返校操作！";
        }
        return msg;
    }

    public PageInfo<Leaveschool> selectLeaveSchool(Student student, String leavestarttime, String leaveendtime,
                                                   String backstarttime, String backendtime,String notbackschool,
                                                   Integer timesort,Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        List<Leaveschool> list = leaveschoolMapper.selectLeaveSchool(student,leavestarttime,leaveendtime,backstarttime,backendtime,notbackschool,timesort);
        PageInfo<Leaveschool> pageInfo = new PageInfo<Leaveschool>(list);
        return pageInfo;
    }

    public String delLeaveSchool(String leaveschoolids) throws Exception {

        String msg;
        int state;
        if (leaveschoolids!=null && leaveschoolids !=""){
            List<Integer> lss=new ArrayList<Integer>();
            String[] ids = leaveschoolids.split(",");
            for (String i:ids){
                lss.add(Integer.parseInt(i));
            }
            LeaveschoolExample leaveschoolExample = new LeaveschoolExample();
            LeaveschoolExample.Criteria criteria = leaveschoolExample.createCriteria();
            criteria.andLeaveschoolidIn(lss);
            try {
                state = leaveschoolMapper.deleteByExample(leaveschoolExample);
                if (state==0) msg = "删除失败！可能不能用String";
                else msg="成功删除"+state+"条记录！";
            }catch (Exception e){
                e.printStackTrace();
                msg = "删除出错";
            }
        }else msg="删除失败，请选择要删除的行";
        return msg;
    }
}
