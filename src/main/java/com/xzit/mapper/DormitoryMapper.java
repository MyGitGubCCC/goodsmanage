package com.xzit.mapper;

import com.xzit.entity.Dormitory;
import com.xzit.entity.DormitoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormitoryMapper {
    int countByExample(DormitoryExample example);

    int deleteByExample(DormitoryExample example);

    int deleteByPrimaryKey(Integer dormitoryid);

    int insert(Dormitory record);

    int insertSelective(Dormitory record);

    List<Dormitory> selectByExample(DormitoryExample example);

    Dormitory selectByPrimaryKey(Integer dormitoryid);

    int updateByExampleSelective(@Param("record") Dormitory record, @Param("example") DormitoryExample example);

    int updateByExample(@Param("record") Dormitory record, @Param("example") DormitoryExample example);

    int updateByPrimaryKeySelective(Dormitory record);

    int updateByPrimaryKey(Dormitory record);
}