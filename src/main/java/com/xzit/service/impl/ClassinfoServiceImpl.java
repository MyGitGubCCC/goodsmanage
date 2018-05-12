package com.xzit.service.impl;

import com.xzit.entity.Classinfo;
import com.xzit.entity.ClassinfoExample;
import com.xzit.mapper.ClassinfoMapper;
import com.xzit.service.ClassinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/10.
 */
@Service
public class ClassinfoServiceImpl implements ClassinfoService {
    @Autowired
    private ClassinfoMapper classinfoMapper;
    public Classinfo selectByPrimaryKey(Integer classid) throws Exception {
        return classinfoMapper.selectByPrimaryKey(classid);
    }

    public List<Classinfo> selectByExample(ClassinfoExample example) throws Exception {
        return classinfoMapper.selectByExample(example);
    }

    public List<Classinfo> selectClassinfoByAcademyidAndCampusid(Integer campusid, Integer academyid) {
        return classinfoMapper.selectClassinfoByAcademyidAndCampusid(campusid,academyid);
    }
}
