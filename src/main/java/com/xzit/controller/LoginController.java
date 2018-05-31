package com.xzit.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzit.entity.*;
import com.xzit.service.AdminService;
import com.xzit.service.AuntService;
import com.xzit.service.LoginService;
import com.xzit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Liu on 2018/1/5.
 */
@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private AuntService auntService;
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login.action")
    public ModelAndView login()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/login");
        return mv;
    }
    //H5首页
    @RequestMapping(value = "/index.action")
    public ModelAndView index()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main/index2");
        return mv;
    }

    @RequestMapping(value = "/goodsmanage.action")
    public ModelAndView goodsmanageMain()throws Exception{
        /*httpSession.setAttribute("name",name);
        httpSession.setAttribute("role",role);
        httpSession.setAttribute("number",number);*/
        ModelAndView mv = new ModelAndView();
       // mv.addObject("number",number);
        mv.setViewName("main/main");
        return mv;
    }

    @RequestMapping(value = "/loginJudge.action")
    @ResponseBody
    public void loginJudge(String username,String password,HttpServletResponse response,HttpSession httpSession)throws Exception{
        String name = null,role = null,number = null;
        if (username.indexOf("ad")!=-1){
            AdminExample adminExample = new AdminExample();
            AdminExample.Criteria criteria = adminExample.createCriteria();
            criteria.andAdminnoEqualTo(username);
            criteria.andAdminpasswordEqualTo(password);
            Admin admin = new Admin();
            if (adminService.selectByExample(adminExample)!=null){
                admin = adminService.selectByExample(adminExample);
                name = admin.getAdminno();
                role = "管理员";
                number = admin.getAdminno();
            }

        }else if (username.indexOf("AY")!=-1){
            AuntExample auntExample = new AuntExample();
            AuntExample.Criteria criteria = auntExample.createCriteria();
            criteria.andAuntnoEqualTo(username);
            criteria.andAuntpasswordEqualTo(password);
            Aunt aunt = new Aunt();
            if (auntService.selectByExample(auntExample)!=null){
                aunt = auntService.selectByExample(auntExample);
                name = aunt.getAuntname();
                role = "宿管";
                number = aunt.getAuntno();
            }
        }else{
            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andSnoEqualTo(username);
            criteria.andSpwdEqualTo(password);
            Student student = new Student();
            if (studentService.selectByExample(studentExample)!=null){
                student = studentService.selectByExample(studentExample);
                name = student.getSname();
                role = "学生";
                number = student.getSno();
            }
        }
        httpSession.setAttribute("name",name);
        httpSession.setAttribute("role",role);
        httpSession.setAttribute("number",number);
        JSONObject obj = new JSONObject();
        obj.put("name",name);
        obj.put("role",role);
        obj.put("number",number);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(obj.toString());
    }

    @RequestMapping(value = "/logout.action")
    @ResponseBody
    public String logout(HttpSession httpSession)throws Exception{
        httpSession.removeAttribute("name");
        httpSession.removeAttribute("role");
        httpSession.removeAttribute("number");
       return "退出成功";
    }

    @RequestMapping(value = "/modifyPasswordInfo.action")
    @ResponseBody
    public Map modifyPasswordInfo(String username,String password)throws Exception{
        String str = "";
        int num = loginService.updatePwdByUsername(username,password);
        if(num>0){
            str = "true";
        }else {
            str = "false";
        }
       /* ObjectMapper mapper = new ObjectMapper();
        try {
            str = mapper.writeValueAsString(str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
        Map<String,String> map = new HashMap<String, String>();
        map.put("str",str);
        return map;
    }

}
