package com.xzit.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.Access;
import com.xzit.entity.AccessExample;
import com.xzit.service.AccessService;
import com.xzit.until.DataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by caochengcheng on 2018/4/8.
 */
@Controller
public class AccessController {
    @Autowired
    private AccessService accessService;

    @RequestMapping(value = "/accessin.action")
    public ModelAndView accessin()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("access/accessin");
        return mv;
    }

    //物品外出记录
    @RequestMapping(value = "/goodsout.action")
    public ModelAndView goodsout()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("access/goodsout");
        return mv;
    }
    //物品外出记录
    @RequestMapping(value = "/goodsin.action")
    public ModelAndView goodsin()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("access/goodsin");
        return mv;
    }
    @RequestMapping(value = "accesslist.action")
    @ResponseBody
    public DataGrid<Access> selectAccess(String sno, String sname, String goodsname,
                                         Integer buildingid, Integer dormitoryid, Integer inorout,
                                         String starttime, String endtime, Integer timesort,
                                         Integer page, Integer rows, HttpSession session)throws Exception{
        String role = (String) session.getAttribute("role");
        String number = (String) session.getAttribute("number");
        List<Access> accessids = accessService.selectAccessid(sno,sname,goodsname, buildingid,dormitoryid,inorout,
                                                             starttime,endtime,role,number);
        List<Integer> accessidsforint = new ArrayList<Integer>();
        //默认给他一个-1，好在下面添加时候没有数据也会有个-1。
        accessidsforint.add(-1);
        for (Access a:accessids){
            accessidsforint.add(a.getAccessid());
        }
        AccessExample accessExample = new AccessExample();
        AccessExample.Criteria accessExampleCriteria = accessExample.createCriteria();
        accessExampleCriteria.andAccessidIn(accessidsforint);
        if (timesort!=null){
           if (timesort==1)accessExample.setOrderByClause("accessid desc");
        }else {
            accessExample.setOrderByClause("accessid desc");
        }
        PageInfo<Access> accessPageInfo = accessService.selectByExample(accessExample,page,rows);
        DataGrid<Access> dataGrid = new DataGrid<Access>();
        dataGrid.setTotal(accessPageInfo.getTotal());
        dataGrid.setRows(accessPageInfo.getList());
        return dataGrid;
    }

    //添加出入记录，根据前台传过来的inorout判断是出是入
    @RequestMapping(value = "addAccessForGoodsOut.action")
    @ResponseBody
    public void addAccessForGoodsOut(Access access, HttpServletResponse response)throws Exception{
        String msg="异常";
        int state=0;
        if (access.getGoodsid()!=null){
            //加入贵重物品的出入时间
            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.format(day);
            access.setTime(day);

            //如果没有备注加入默认备注
            if (access.getRemark()==null || access.getRemark()=="") access.setRemark("正常出入");
            state = accessService.insertSelective(access);
            if (state==0) msg = "录入失败！请查看是否存在物品！";
            else msg="录入成功";
        }else msg="录入失败！请选择外出物品！";
        JSONObject obj = new JSONObject();
        obj.put("success",true);
        obj.put("msg",msg);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(obj.toString());
    }

    @RequestMapping(value = "delAccess.action")
    @ResponseBody
    public void  delAccess(String temID,HttpServletResponse response)throws Exception{
        String msg="异常";
        int state=0;
        if (temID!=null && temID !=""){
            List<Integer> accessids=new ArrayList<Integer>();
            String[] ids = temID.split(",");
            for (String i:ids){
                accessids.add(Integer.parseInt(i));
            }
            state = accessService.delAccessByAccessid(accessids);
            if (state==0) msg = "删除失败！可能不能用String";
            else msg="成功删除"+state+"条记录";
        }else msg="删除失败，请选择要删除的行";
        JSONObject obj = new JSONObject();
        obj.put("success",true);
        obj.put("msg",msg);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(obj.toString());
    }
}
