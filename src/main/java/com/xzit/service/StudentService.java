package com.xzit.service;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Student;
import com.xzit.entity.StudentExample;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/10.
 */
public interface StudentService {
       PageInfo<Student> selectByExample(StudentExample example,Integer pageNo,Integer pageSize);
       Student selectBySno(String sno)throws Exception;
       int updateByPrimaryKeySelective(Student record)throws Exception;
       //为了根据用户名和密码查询是否有此人
       Student selectByExample(StudentExample example);
}
