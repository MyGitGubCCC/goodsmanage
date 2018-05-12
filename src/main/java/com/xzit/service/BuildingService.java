package com.xzit.service;

import com.xzit.entity.Building;
import com.xzit.entity.BuildingExample;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/9.
 */
public interface BuildingService {
    List<Building> selectByExample(BuildingExample example);
}
