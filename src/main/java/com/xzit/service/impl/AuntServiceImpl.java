package com.xzit.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public String insertOrUpdateAunt(Aunt aunt) throws Exception {
        String msg="异常";
        int state=0;
        if (aunt.getAuntno().startsWith("AY")){
            if (aunt.getAuntid()!=null){
                try {
                    state = auntMapper.updateByPrimaryKeySelective(aunt);
                }catch (Exception e){
                    e.printStackTrace();
                }
                if (state==0) msg = "更新失败！请查看账号是否重复";
                else msg="更新成功";
            }else {
                try {
                    state = auntMapper.insertSelective(aunt);
                }catch (Exception e){
                    e.printStackTrace();
                }
                if (state==0) msg = "添加失败,账号重复";
                else msg="添加成功";
            }
        }else {
            msg="账号请以AY开头";
        }
        return msg;
    }

    public String deleteAuntByAuntid(int auntid) throws Exception {
        String msg="删除成功！";
        try {
            auntMapper.deleteByPrimaryKey(auntid);
        }catch (Exception e){
            e.printStackTrace();
            msg = "删除失败";
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            msg = mapper.writeValueAsString(msg);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
