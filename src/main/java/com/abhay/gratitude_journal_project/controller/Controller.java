package com.abhay.gratitude_journal_project.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String getHomePage(){
        return "homePage";
    }
}
