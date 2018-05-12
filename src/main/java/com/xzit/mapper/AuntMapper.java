package com.xzit.mapper;

import com.xzit.entity.Aunt;
import com.xzit.entity.AuntExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuntMapper {
    int countByExample(AuntExample example);

    int deleteByExample(AuntExample example);

    int deleteByPrimaryKey(Integer auntid);

    int insert(Aunt record);

    int insertSelective(Aunt record);

    List<Aunt> selectByExample(AuntExample example);

    Aunt selectByPrimaryKey(Integer auntid);

    int updateByExampleSelective(@Param("record") Aunt record, @Param("example") AuntExample example);

    int updateByExample(@Param("record") Aunt record, @Param("example") AuntExample example);

    int updateByPrimaryKeySelective(Aunt record);

    int updateByPrimaryKey(Aunt record);

    //根据账号修改密码
    int updateAuntpasswordByAuntno(Aunt aunt);

    Aunt selectAuntByAuntno(String auntno);
}