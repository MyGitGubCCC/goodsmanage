package com.xzit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.Student;
import com.xzit.entity.StudentExample;
import com.xzit.mapper.StudentMapper;
import com.xzit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/10.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public PageInfo<Student> selectByExample(StudentExample example,Integer pageNo,Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        List<Student> goodsList = studentMapper.selectByExample(example);
        PageInfo<Student> pageInfo = new PageInfo<Student>(goodsList);
        return pageInfo;
    }

    public Student selectBySno(String sno) throws Exception {
        return studentMapper.selectBySno(sno);
    }

    public int updateByPrimaryKeySelective(Student record) throws Exception {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    public Student selectByExample(StudentExample example) {
        List<Student> students = studentMapper.selectByExample(example);
        Student student = null;
        if (students.size()>0){
            student = students.get(0);
        }
        return student;
    }
}
