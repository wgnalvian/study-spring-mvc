package com.spring_mvc.spring_mvc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DateController {
    
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping(path = "/date",method = RequestMethod.GET)
    public void getDate(@RequestParam(name = "date", required = false) Date date, 
        HttpServletRequest request,
        HttpServletResponse response) throws IOException {
        String responseText = simpleDateFormat.format(date);
        response.getWriter().print(responseText);
    }

}
