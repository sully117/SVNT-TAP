package com.javaxiaodi.springapi.config;

import com.javaxiaodi.springapi.component.LoginHandlerInterceptor;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: Xiaodi Tao
 * @className: UserConfig
 * @packageName: config
 * @description: This is the config class,setting up the path to intercept
 * @data: 2019-10-25
 **/
@Configuration
public class UserConfig implements WebMvcConfigurer {
    // AddViewController is used for webMVC format
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        org.slf4j.Logger Logger = LoggerFactory.getLogger(UserConfig.class);
        Logger.info("addViewControllers");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurerAdapter(){
        WebMvcConfigurer adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
            }
            // The interceptor will add all the path to be intercepted,
            // except for those in the exclude path
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login","/user/register");
            }
        };
        return adapter;
    }

}

