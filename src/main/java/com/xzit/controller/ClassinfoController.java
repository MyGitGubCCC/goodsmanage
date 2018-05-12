package com.xzit.controller;

import com.xzit.entity.Classinfo;
import com.xzit.entity.ClassinfoExample;
import com.xzit.service.ClassinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by caochengcheng on 2018/4/10.
 */
@Controller
public class ClassinfoController {
    @Autowired
    private ClassinfoService classinfoService;

    @RequestMapping(value = "selectAllClassinfo.action")
    @ResponseBody
    private List<Classinfo> selectAllClassinfo()throws Exception{
        List<Classinfo> classinfos;
        ClassinfoExample classinfoExample = new ClassinfoExample();
        classinfos = classinfoService.selectByExample(classinfoExample);
        return classinfos;
    }
    @RequestMapping(value = "selectClassinfoByAcademyid.action")
    @ResponseBody
    private List<Classinfo> selectClassinfoByAcademyid(int academyid)throws Exception{
        List<Classinfo> classinfos;
        ClassinfoExample classinfoExample = new ClassinfoExample();
        ClassinfoExample.Criteria criteriaClassinfo = classinfoExample.createCriteria();
        criteriaClassinfo.andAcademyidEqualTo(academyid);
        classinfos = classinfoService.selectByExample(classinfoExample);
        return classinfos;
    }
}
