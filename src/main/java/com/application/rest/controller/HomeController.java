package com.application.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String Home(){
        return "API REST FUNCIONANDO, USA (/api/maker) O (/api/product)";
    }
}
