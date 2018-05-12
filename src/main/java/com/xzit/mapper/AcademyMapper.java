package com.xzit.mapper;

import com.xzit.entity.Academy;
import com.xzit.entity.AcademyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AcademyMapper {
    int countByExample(AcademyExample example);

    int deleteByExample(AcademyExample example);

    int deleteByPrimaryKey(Integer academyid);

    int insert(Academy record);

    int insertSelective(Academy record);

    List<Academy> selectByExample(AcademyExample example);

    Academy selectByPrimaryKey(Integer academyid);

    int updateByExampleSelective(@Param("record") Academy record, @Param("example") AcademyExample example);

    int updateByExample(@Param("record") Academy record, @Param("example") AcademyExample example);

    int updateByPrimaryKeySelective(Academy record);

    int updateByPrimaryKey(Academy record);
}