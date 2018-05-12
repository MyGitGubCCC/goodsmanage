package com.xzit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.Goods;
import com.xzit.mapper.GoodsMapper;
import com.xzit.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/10.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public PageInfo<Goods> selectBySno(String sno,Integer pageNo,Integer pageSize) throws Exception {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        List<Goods> goodsList = goodsMapper.selectBySno(sno);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(goodsList);
        return pageInfo;
    }

    public int updateByPrimaryKeySelective(Goods record) throws Exception {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    public int insertSelective(Goods record) throws Exception {
        return goodsMapper.insertSelective(record);
    }

    public int deleteByPrimaryKey(Integer goodsid) throws Exception {
        return goodsMapper.deleteByPrimaryKey(goodsid);
    }

    public List<Goods> selectGoodsListBySid(String sno) throws Exception {
        return goodsMapper.selectBySno(sno);
    }

    public Goods selectByPrimaryKey(Integer goodsid) throws Exception {
        return goodsMapper.selectByPrimaryKey(goodsid);
    }
}
