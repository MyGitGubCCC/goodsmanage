package com.xzit.service.impl;

import com.xzit.entity.Building;
import com.xzit.entity.BuildingExample;
import com.xzit.mapper.BuildingMapper;
import com.xzit.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/9.
 */
@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingMapper buildingMapper;

    public List<Building> selectByExample(BuildingExample example) {
        return buildingMapper.selectByExample(example);
    }
}
