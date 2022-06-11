package com.abhay.gratitude_journal_project.controller;

import com.abhay.gratitude_journal_project.service.GratitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    GratitudeService gratitudeService;
    @GetMapping("/")
    public String getHomePage(Model model){
        model.addAttribute("GratitudeDataList",gratitudeService.getListOfGratitudeData());
        return "homePage";
    }

    @GetMapping("/addGratitude")
    public String getAddGratitudePage(){
        return "addGratitudePage";
    }
}
