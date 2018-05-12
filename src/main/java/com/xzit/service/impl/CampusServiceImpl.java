package com.xzit.service.impl;

import com.xzit.entity.Campus;
import com.xzit.entity.CampusExample;
import com.xzit.mapper.CampusMapper;
import com.xzit.service.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/11.
 */
@Service
public class CampusServiceImpl implements CampusService {

    @Autowired
    private CampusMapper campusMapper;
    public List<Campus> selectByExample(CampusExample example) throws Exception {
        return campusMapper.selectByExample(example);
    }
}
