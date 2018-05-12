package com.xzit.service.impl;

import com.xzit.entity.Dormitory;
import com.xzit.entity.DormitoryExample;
import com.xzit.mapper.DormitoryMapper;
import com.xzit.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/9.
 */
@Service
public class DormitoryServiceImpl implements DormitoryService {

    @Autowired
    private DormitoryMapper dormitoryMapper;

    public List<Dormitory> selectByExample(DormitoryExample example){
        return dormitoryMapper.selectByExample(example);
    }
}
