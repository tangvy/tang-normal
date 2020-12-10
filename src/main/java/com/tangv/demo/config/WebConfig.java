package com.tangv.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/3/7 3:31 下午
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /*@Autowired
    private AuthorityInterceptor authorityInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor).addPathPatterns("/r/**");
    }*/

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");
    }
}
