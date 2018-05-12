package com.xzit.service;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Access;
import com.xzit.entity.AccessExample;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/8.
 */
public interface AccessService {
    PageInfo<Access> selectByExample(AccessExample example, Integer pageNo, Integer pageSize)throws Exception;
    List<Access> selectAccessid(String sno,String sname,String goodsname,
                                Integer buildingid,Integer dormitoryid,Integer inorout,
                                String starttime,String endtime,String role,String number);
    int insertSelective(Access record)throws Exception;
    int delAccessByAccessid(List<Integer> accessids);
}
