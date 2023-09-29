package com.example.gtics_lab7_20180805.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String index(){
        return "GticsF";
    }
}
