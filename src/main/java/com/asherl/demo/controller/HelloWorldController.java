package com.asherl.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String sayHello() {
        return "<span style='color:" + "green"
                + "; font-size: 36px; text-align: center; display: flex; justify-content: center; align-items: center; height: 100vh;'>Hello World</span>";
    }
}
