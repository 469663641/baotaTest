package com.example.service.intercptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by duguangquan on 2018/5/13.
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //设置编码
        httpServletRequest.setCharacterEncoding("utf-8");

        //从session中拿到登录用户
        Object user = httpServletRequest.getSession().getAttribute("user");

        System.err.println("preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        //Object o 目标controller的对象
        //modelAndView返回的view
        //modelAndView.addObject("hahah");
        //modelAndView.setViewName("");
        System.err.println("postHandle");

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.err.println("afterCompletion");

    }
}
