package com.spring_mvc.spring_mvc.controller;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring_mvc.spring_mvc.model.HelloRequest;
import com.spring_mvc.spring_mvc.service.HelloService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class HelloController {

    @Autowired
    private HelloService  helloService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(path = "/hello", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String helloWorld(
        @RequestParam(name = "name", required =  false) String name,
        @RequestPart(name = "file", required = false) MultipartFile file,
        HttpServletRequest request) throws IOException {

        Path path = Path.of("src/main/resources/static/" + file.getOriginalFilename());
        file.transferTo(path);

        String responseText = helloService.hello(name);
        return responseText;
    }

    @RequestMapping(path = "/hello/{helloId}", method=RequestMethod.GET)    
    @ResponseBody
    public String getPathHello(@PathVariable("helloId") String helloId){
        return "Hello " + helloId;
    }

    @PostMapping(path = "/hello-object", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody    
    public String getHelloByObject(@RequestBody @Valid HelloRequest helloRequest) throws JsonProcessingException{
        // if (result.hasErrors()) {
           
        //     return result.getFieldErrors().get(0).getDefaultMessage();
        // }
        return objectMapper.writeValueAsString(helloRequest);
    }

    @PostMapping(path = "/hello-re", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> testResponseEntity(@RequestBody String request) throws JsonProcessingException{
        HelloRequest helloRequest = objectMapper.readValue(request, HelloRequest.class);
        String resp =  objectMapper.writeValueAsString(helloRequest);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resp);
    }

    @PostMapping(path = "/hello-ma", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> testModelAtribute(@ModelAttribute HelloRequest request) throws JsonProcessingException{
        log.info(request.toString());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(objectMapper.writeValueAsString(request));
    }

    @PostMapping(path = "/hello-rs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> testResolver(HelloRequest request) throws JsonProcessingException{
        log.info(request.toString());
        return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(request));

    }
    



}
