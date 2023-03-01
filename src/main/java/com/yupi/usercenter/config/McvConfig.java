package com.yupi.usercenter.config;

import com.yupi.usercenter.utils.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 * @title McvConfig
 * @description TODO 拦截器配置类
 * @author Skadhi
 * @version 1.0.0
 * @create 2023-03-01 20:28
 **/
@Configuration
public class McvConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns(
                        "/user/register",
                        "/user/login",
                        "/user/logout"
                );

    }
}
