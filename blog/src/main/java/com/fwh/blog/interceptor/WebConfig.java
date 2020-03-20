package com.fwh.blog.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                // 拦截admin带有后缀的路径
                .addPathPatterns("/admin/**")
                // 排除掉admin
                .excludePathPatterns("/admin")
                // 排除掉admin/login
                .excludePathPatterns("/admin/login");
    }
}
