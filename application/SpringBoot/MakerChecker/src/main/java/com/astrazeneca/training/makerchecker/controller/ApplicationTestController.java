package com.astrazeneca.training.makerchecker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationTestController {

    @RequestMapping("/")
    public String home(){
        return "Welcome, Project is up !!";
    }


}
