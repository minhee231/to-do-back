package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String welcome() {
        return "Hello World";
    }

    @GetMapping(value = "/health/chcker")
    public String healthChecker() {
        return "success";
    }

}
