package com.xzit.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by caochengcheng on 2018/5/11.
 */
public class AuthorizationInterceptor implements HandlerInterceptor {
    private static final  String[] IGNORE_URI = {"/login.action","/loginJudge.action"};
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("AuthorizationInterceptor preHandle -->");
        boolean flag = false;
        String servletPath = httpServletRequest.getServletPath();
        for (String s:IGNORE_URI){
            if (servletPath.contains(s)){
                flag = true;
                break;
            }
        }
        if (!flag){
            String role = (String) httpServletRequest.getSession().getAttribute("role");
            if (role !=null ){
                System.out.println("AuthorizationInterceptor旅行请求:");
                flag = true;
            }else {
                System.out.println("AuthorizationInterceptor拦截请求：");
               // httpServletRequest.getRequestDispatcher("/login.action").forward(httpServletRequest,httpServletResponse);
               httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login.action");

            }
        }
        return flag;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("AuthorizationInterceptor portHandle -->");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("AuthorizationInterceptor afterCompletion -->");
    }
}
