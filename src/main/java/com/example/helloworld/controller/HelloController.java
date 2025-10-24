package com.example.helloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.environment:Local}")
    private String environment;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world from '" + environment + "'";
    }
}
