package com.xzit.controller;

import com.xzit.entity.Building;
import com.xzit.entity.BuildingExample;
import com.xzit.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/9.
 */
@Controller
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @RequestMapping(value = "selectAllBuilding.action")
    @ResponseBody
    public List<Building> selectAllBuilding()throws Exception{
        List<Building> buildings;
        BuildingExample buildingExample = new BuildingExample();
        BuildingExample.Criteria buildingExampleCriteria = buildingExample.createCriteria();
        buildings = buildingService.selectByExample(buildingExample);
        return buildings;
    }
}
