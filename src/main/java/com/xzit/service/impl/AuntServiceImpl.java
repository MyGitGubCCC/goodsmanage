package com.xzit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.Aunt;
import com.xzit.entity.AuntExample;
import com.xzit.mapper.AuntMapper;
import com.xzit.service.AuntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/20.
 */
@Service
public class AuntServiceImpl implements AuntService {
    @Autowired
    private AuntMapper auntMapper;

    public PageInfo<Aunt> selectByExample(AuntExample example, Integer pageNo, Integer pageSize) throws Exception {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        List<Aunt> list = auntMapper.selectByExample(example);
        PageInfo<Aunt> pageInfo = new PageInfo<Aunt>(list);
        return pageInfo;
    }

    public Aunt selectByExample(AuntExample example) {
        List<Aunt> list = auntMapper.selectByExample(example);
        Aunt aunt = null;
        if (list.size()>0){
            aunt = list.get(0);
        }
        return aunt;
    }
}
