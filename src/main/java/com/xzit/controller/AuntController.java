package com.xzit.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Aunt;
import com.xzit.entity.AuntExample;
import com.xzit.service.AuntService;
import com.xzit.until.DataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by caochengcheng on 2018/4/20.
 */
@Controller
public class AuntController {
    @Autowired
    private AuntService auntService;

    @RequestMapping(value = "/aunt.action")
    public ModelAndView aunt()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aunt/aunt");
        return mv;
    }

    @RequestMapping(value = "selectAuntByExample.action")
    @ResponseBody
    public DataGrid<Aunt> selectAuntByExample(Aunt a,Integer page, Integer rows)throws Exception{
        AuntExample auntExample = new AuntExample();
        AuntExample.Criteria auntCriteria = auntExample.createCriteria();
        if(a.getAuntname()!=null) auntCriteria.andAuntnameLike("%"+a.getAuntname()+"%");
        if(a.getAuntno()!=null) auntCriteria.andAuntnoLike("%"+a.getAuntno()+"%");
        if(a.getAuntphoneno()!=null) auntCriteria.andAuntphonenoLike("%"+a.getAuntphoneno()+"%");
        if(a.getBuildingid()!=null) auntCriteria.andBuildingidEqualTo(a.getBuildingid());

        PageInfo<Aunt> auntPageInfo = auntService.selectByExample(auntExample,page,rows);
        DataGrid<Aunt> dataGrid = new DataGrid<Aunt>();
        dataGrid.setTotal(auntPageInfo.getTotal());
        dataGrid.setRows(auntPageInfo.getList());
        return dataGrid;
    }
}
