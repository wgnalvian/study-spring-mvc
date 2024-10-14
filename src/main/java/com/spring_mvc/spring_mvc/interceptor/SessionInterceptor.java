package com.spring_mvc.spring_mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Logika sebelum request dikirim ke controller
        System.out.println("Pre Handle method is Calling");
        return true; // return false jika ingin menghentikan eksekusi request
    }
    
}
