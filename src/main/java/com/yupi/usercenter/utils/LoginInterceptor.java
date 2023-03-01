package com.yupi.usercenter.utils;

import com.yupi.usercenter.common.ErrorCode;
import com.yupi.usercenter.exception.BusinessException;
import com.yupi.usercenter.model.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.yupi.usercenter.constant.UserConstant.USER_LOGIN_STATE;

/***
 * @title LoginInterceptor
 * @description TODO 全局请求拦截器
 * @author Skadhi
 * @version 1.0.0
 * @create 2023-03-01 20:00
 **/
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1. 获取session
        HttpSession session = request.getSession();
        //2. 获取session中的用户
        Object user = session.getAttribute(USER_LOGIN_STATE);
        //3. 判断用户是否存在
        if (user == null) {
            //4. 不存在，拦截
            log.info("user login failed, userAccount cannont match userPassword");
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }
        //5. 存在，保存用户信息到TheadLocal
        UserHolder.saveUser((User) user);

        //6. 放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       //移除用户
        UserHolder.removeUser();
    }
}
