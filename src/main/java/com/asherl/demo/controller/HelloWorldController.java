package com.asherl.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hi")
    public String sayHi() {
        return "Hi, World!";
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello, World! ";
    }
}
