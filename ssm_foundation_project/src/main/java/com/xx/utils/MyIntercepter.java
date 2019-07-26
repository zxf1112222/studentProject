package com.xx.utils;

import com.xx.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * description: 登陆拦截类
 * @author 钟晓锋（xiaofeng.zhong@ucarinc.com）
 * @date 2019-07-24 10:23
 * @version 1.0
 */
public class MyIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("进入了拦截器！");
        String contextPath = request.getServletPath();
        if (1==1){
            return true;
        }
        System.out.println("con:"+contextPath);
        User user = (User) request.getSession().getAttribute("user");
        //user = new User();
        if (user != null) {
            System.out.println("user:" + user.getId() + "\t" + user.getUsername());
            System.out.println("不拦截");
            return true;
        } else {
            System.out.println("拦截成功");
            response.sendRedirect("http://localhost:8080/dist/index.html#/pagetologin");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
