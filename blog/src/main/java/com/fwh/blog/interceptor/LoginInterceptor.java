package com.fwh.blog.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 登录界面的拦截器
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // 判断session中的用户是否为空
        if (request.getSession().getAttribute("user") == null) {
            // 若果诶空,重定向到登录页面
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}
