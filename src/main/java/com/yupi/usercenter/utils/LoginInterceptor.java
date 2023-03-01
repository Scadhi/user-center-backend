package com.yupi.usercenter.utils;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * @title LoginInterceptor
 * @description TODO 全局请求拦截器
 * @author Skadhi
 * @version 1.0.0
 * @create 2023-03-01 20:00
 **/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 获取session

        //2. 获取session中的用户

        //3. 判断用户是否存在

        //4. 不存在，拦截

        //5. 存在

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
