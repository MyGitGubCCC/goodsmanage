package com.xzit.service.impl;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.Access;
import com.xzit.entity.AccessExample;
import com.xzit.entity.Aunt;
import com.xzit.mapper.AccessMapper;
import com.xzit.mapper.AuntMapper;
import com.xzit.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/8.
 */
@Service
public class AccessServiceImpl implements AccessService {

    @Autowired
    private AccessMapper accessMapper;
    @Autowired
    private AuntMapper auntMapper;

    public PageInfo<Access> selectByExample(AccessExample example, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        List<Access> list = accessMapper.selectByExample(example);
        PageInfo<Access> pageInfo = new PageInfo<Access>(list);
        return pageInfo;
    }

    public List<Access> selectAccessid(String sno,String sname,String goodsname,
                                       Integer buildingid,Integer dormitoryid,Integer inorout,
                                       String starttime,String endtime,String role,String number) {
        Aunt aunt;
        if (role=="宿管"&& buildingid ==null) {
            aunt = auntMapper.selectAuntByAuntno(number);
            buildingid = aunt.getBuildingid();
        }
        return accessMapper.selectAccessid(sno,sname,goodsname, buildingid,dormitoryid,inorout,
                starttime,endtime);
    }

    public int insertSelective(Access record) throws Exception {
        return accessMapper.insertSelective(record);
    }

    public int delAccessByAccessid(List<Integer> accessids) {
        return accessMapper.delAccessByAccessid(accessids);
    }
}
