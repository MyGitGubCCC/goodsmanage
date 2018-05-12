package com.xzit.controller;

import com.xzit.entity.Campus;
import com.xzit.entity.CampusExample;
import com.xzit.service.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/11.
 */
@Controller
public class CampusController {
    @Autowired
    private CampusService campusService;

    @RequestMapping(value = "/selectAllCampus.action")
    @ResponseBody
    public List<Campus> selectAllCampus()throws Exception{
        CampusExample campusExample = new CampusExample();
        CampusExample.Criteria criteriaCampus = campusExample.createCriteria();
        List<Campus> campusList = campusService.selectByExample(campusExample);
        return campusList;
    }
}
