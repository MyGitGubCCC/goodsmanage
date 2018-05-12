package com.xzit.controller;

import com.xzit.entity.Academy;
import com.xzit.entity.AcademyExample;
import com.xzit.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/11.
 */
@Controller
public class AcademyController {
    @Autowired
    private AcademyService academyService;

    @RequestMapping(value = "/selectAllAcademy.action")
    @ResponseBody
    public List<Academy> selectAllAcademy()throws Exception{
        AcademyExample academyExample = new AcademyExample();
        List<Academy> academyList = academyService.selectByExample(academyExample);
        return academyList;
    }
    @RequestMapping(value = "/selectAcademyByCampusid.action")
    @ResponseBody
    public List<Academy> selectAcademyByCampusid(int campusid)throws Exception{
        AcademyExample academyExample = new AcademyExample();
        AcademyExample.Criteria criteriaAcademy = academyExample.createCriteria();
        criteriaAcademy.andCampusidEqualTo(campusid);
        List<Academy> academyList = academyService.selectByExample(academyExample);
        return academyList;
    }
}
