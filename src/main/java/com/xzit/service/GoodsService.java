package com.xzit.service;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Goods;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/10.
 */
public interface GoodsService {
    PageInfo<Goods> selectBySno(String sno,Integer pageNo,Integer pageSize)throws Exception;
    int updateByPrimaryKeySelective(Goods record)throws Exception;
    int insertSelective(Goods record)throws Exception;
    int deleteByPrimaryKey(Integer goodsid)throws Exception;
    List<Goods> selectGoodsListBySid(String sno)throws Exception;
    Goods selectByPrimaryKey(Integer goodsid)throws Exception;
}
