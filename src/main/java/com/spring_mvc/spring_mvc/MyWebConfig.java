package com.spring_mvc.spring_mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring_mvc.spring_mvc.interceptor.SessionInterceptor;
import com.spring_mvc.spring_mvc.resolver.HelloRequestResolver;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    
    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Autowired
    private HelloRequestResolver helloRequestResolver;


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(helloRequestResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
    }
    
}
