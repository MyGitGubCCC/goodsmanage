package com.xzit.mapper;

import com.xzit.entity.Campus;
import com.xzit.entity.CampusExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CampusMapper {
    int countByExample(CampusExample example);

    int deleteByExample(CampusExample example);

    int deleteByPrimaryKey(Integer campusid);

    int insert(Campus record);

    int insertSelective(Campus record);

    List<Campus> selectByExample(CampusExample example);

    Campus selectByPrimaryKey(Integer campusid);

    int updateByExampleSelective(@Param("record") Campus record, @Param("example") CampusExample example);

    int updateByExample(@Param("record") Campus record, @Param("example") CampusExample example);

    int updateByPrimaryKeySelective(Campus record);

    int updateByPrimaryKey(Campus record);
}