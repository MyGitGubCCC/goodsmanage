package com.xzit.service;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Leaveschool;
import com.xzit.entity.LeaveschoolExample;
import com.xzit.entity.Student;

import java.util.List;

/**
 * Created by caochengcheng on 2018/5/9.
 */
public interface LeaveSchoolService {
    PageInfo<Leaveschool> selectByExample(String role,String number,Integer pageNo, Integer pageSize)throws Exception;
    String addLeaveSchool(String sno,String remark);
    String addBackSchool(String sno,String remark);
    PageInfo<Leaveschool> selectLeaveSchool(Student student,String leavestarttime,String leaveendtime,
                                            String backstarttime,String backendtime,String notbackschool,
                                            Integer timesort,Integer pageNo, Integer pageSize);
    String delLeaveSchool(String leaveschoolids)throws Exception;
}
