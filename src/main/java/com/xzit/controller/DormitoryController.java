package com.xzit.controller;

import com.xzit.entity.Dormitory;
import com.xzit.entity.DormitoryExample;
import com.xzit.mapper.DormitoryMapper;
import com.xzit.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/9.
 */
@Controller
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    @RequestMapping(value = "selectAllDormitory.action")
    @ResponseBody
    public List<Dormitory> selectAllDormitory()throws Exception{
        List<Dormitory> dormitories;
        DormitoryExample dormitoryExample = new DormitoryExample();
        DormitoryExample.Criteria dormitoryExampleCriteria = dormitoryExample.createCriteria();
        dormitories = dormitoryService.selectByExample(dormitoryExample);
        return dormitories;
    }


}
