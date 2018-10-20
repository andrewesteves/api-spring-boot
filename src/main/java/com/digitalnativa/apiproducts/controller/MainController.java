package com.digitalnativa.apiproducts.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {
    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "Welcome to Spring Boot API";
    }
}
