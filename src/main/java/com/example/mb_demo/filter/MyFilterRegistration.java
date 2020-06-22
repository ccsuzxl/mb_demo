package com.example.mb_demo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterRegistration {

    @Bean
    FilterRegistrationBean<MyFilter> myFilter(){
        FilterRegistrationBean<MyFilter> bean=new FilterRegistrationBean<>();
        bean.setFilter(new MyFilter());
        bean.setOrder(-1);
        bean.addUrlPatterns("/*");
        return bean;
    }
}
