package com.spring_mvc.spring_mvc.converter;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component  
public class StringToDateConverter  implements Converter<String, Date> {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    public Date convert(String source) {
        try {
          return simpleDateFormat.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
