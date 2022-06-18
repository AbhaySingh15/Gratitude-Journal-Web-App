package com.abhay.gratitude_journal_project.controller;

import com.abhay.gratitude_journal_project.model.Gratitude;
import com.abhay.gratitude_journal_project.service.GratitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    GratitudeService gratitudeService;
    @GetMapping("/")
    public String getHomePage(Model model){
        model.addAttribute("GratitudeDataList",gratitudeService.getListOfGratitude());
        return "homePage";
    }
    @ModelAttribute("gratitudeInputObject")
    public Gratitude getGratitudeInputObject(){
        return new Gratitude();
    }

    @GetMapping("/addGratitude")
    public String getAddGratitudePage(){
        return "addGratitudePage";
    }

    @GetMapping("/gratitudeInput")
    public String gratitudeInput(@ModelAttribute("gratitudeInputObject") Gratitude gratitudeInputObject){
        gratitudeService.insertGratitudeIntoDB(gratitudeInputObject);
        return "redirect:/";
    }
}
