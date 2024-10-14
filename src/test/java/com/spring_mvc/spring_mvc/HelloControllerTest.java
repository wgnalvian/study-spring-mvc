package com.spring_mvc.spring_mvc;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import com.spring_mvc.spring_mvc.service.HelloService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HelloService helloService;

    @Test
    void testHelloWorld() throws Exception {
        
        mockMvc.perform(get("/hello?name=Syifa"))
            .andExpect(status().isOk())
            .andExpect(content().string("Hello Syifa"));
    }

    @Test
    void testHelloWorldWithoutName() throws Exception {
         assertEquals("Hello Guest", helloService.hello(null));
         assertEquals("Hello Syifa", helloService.hello("Syifa"));
    }

}