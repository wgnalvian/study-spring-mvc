package com.spring_mvc.spring_mvc.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.spring_mvc.spring_mvc.model.HelloRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HelloRequestResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(HelloRequest.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, 
                                  ModelAndViewContainer mavContainer, 
                                  NativeWebRequest webRequest, 
                                  WebDataBinderFactory binderFactory) {
        log.info("Resolving HelloRequest");
        return new HelloRequest("Hello, World!", null);
    }

    

}
