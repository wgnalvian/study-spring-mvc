package com.spring_mvc.spring_mvc.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.net.URI;

@RestController
public class TodoController {

    private List<String> todos = new ArrayList<>();

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private Integer port;

    @PostMapping(path = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)    
    public List<String> add(@RequestParam(name = "todo") String todo) {
        todos.add(todo);
        String url = "http://localhost:8181/todos";

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        body.add("todo", "Belajar Spring Boot");

        RequestEntity<MultiValueMap<String, Object>> request = RequestEntity.post(URI.create(url))
            .headers(headers)
            .body(body);

        restTemplate.exchange(request, String.class);
        
        return todos;
    }

    public List<String> getTodos() {
        return todos;
    }

    

}
