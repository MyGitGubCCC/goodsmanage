package com.xzit.mapper;

import com.xzit.entity.Access;
import com.xzit.entity.AccessExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccessMapper {
    int countByExample(AccessExample example);

    int deleteByExample(AccessExample example);

    int deleteByPrimaryKey(Integer accessid);

    int insert(Access record);

    int insertSelective(Access record);

    List<Access> selectByExample(AccessExample example);

    Access selectByPrimaryKey(Integer accessid);

    int updateByExampleSelective(@Param("record") Access record, @Param("example") AccessExample example);

    int updateByExample(@Param("record") Access record, @Param("example") AccessExample example);

    int updateByPrimaryKeySelective(Access record);

    int updateByPrimaryKey(Access record);

    //自己写的
    List<Access> selectAccessid(@Param("sno") String sno,@Param("sname") String sname,@Param("goodsname") String goodsname,
                                @Param("buildingid") Integer buildingid,@Param("dormitoryid") Integer dormitoryid,@Param("inorout") Integer inorout,
                                @Param("starttime") String starttime,@Param("endtime") String endtime);
    int delAccessByAccessid(List<Integer> accessids);
}