package com.xzit.mapper;

import com.xzit.entity.Leaveschool;
import com.xzit.entity.LeaveschoolExample;
import com.xzit.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaveschoolMapper {
    int countByExample(LeaveschoolExample example);

    int deleteByExample(LeaveschoolExample example);

    int deleteByPrimaryKey(Integer leaveschoolid);

    int insert(Leaveschool record);

    int insertSelective(Leaveschool record);

    List<Leaveschool> selectByExample(LeaveschoolExample example);

    Leaveschool selectByPrimaryKey(Integer leaveschoolid);

    int updateByExampleSelective(@Param("record") Leaveschool record, @Param("example") LeaveschoolExample example);

    int updateByExample(@Param("record") Leaveschool record, @Param("example") LeaveschoolExample example);

    int updateByPrimaryKeySelective(Leaveschool record);

    int updateByPrimaryKey(Leaveschool record);

    //自己加的
    Leaveschool selectLastLeavesSchoolBySno(String sno);

    List<Leaveschool> selectLeaveSchool(@Param("student") Student student,
                                        @Param("leavestarttime") String leavestarttime,
                                        @Param("leaveendtime") String leaveendtime,
                                        @Param("backstarttime") String backstarttime,
                                        @Param("backendtime") String backendtime,
                                        @Param("notbackschool") String notbackschool,
                                        @Param("timesort") Integer timesort);
}