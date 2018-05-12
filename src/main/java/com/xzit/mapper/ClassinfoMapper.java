package com.xzit.mapper;

import com.xzit.entity.Classinfo;
import com.xzit.entity.ClassinfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassinfoMapper {
    int countByExample(ClassinfoExample example);

    int deleteByExample(ClassinfoExample example);

    int deleteByPrimaryKey(Integer classid);

    int insert(Classinfo record);

    int insertSelective(Classinfo record);

    List<Classinfo> selectByExample(ClassinfoExample example);

    Classinfo selectByPrimaryKey(Integer classid);

    int updateByExampleSelective(@Param("record") Classinfo record, @Param("example") ClassinfoExample example);

    int updateByExample(@Param("record") Classinfo record, @Param("example") ClassinfoExample example);

    int updateByPrimaryKeySelective(Classinfo record);

    int updateByPrimaryKey(Classinfo record);

    //自己加的
    List<Classinfo> selectClassinfoByAcademyidAndCampusid(@Param("campusid") Integer campusid,@Param("academyid") Integer academyid);
}