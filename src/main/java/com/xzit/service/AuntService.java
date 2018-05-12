package com.xzit.service;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Aunt;
import com.xzit.entity.AuntExample;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/20.
 */
public interface AuntService {
    PageInfo<Aunt> selectByExample(AuntExample example, Integer pageNo, Integer pageSize)throws Exception;
    Aunt selectByExample(AuntExample example);
}
