package com.xzit.service;

import com.xzit.entity.Classinfo;
import com.xzit.entity.ClassinfoExample;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/10.
 */
public interface ClassinfoService {
    Classinfo selectByPrimaryKey(Integer classid)throws Exception;
    List<Classinfo> selectByExample(ClassinfoExample example)throws Exception;
    List<Classinfo> selectClassinfoByAcademyidAndCampusid(Integer campusid, Integer academyid);
}
