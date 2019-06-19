package com.waa.dragons.mediationattendance.controller;


import com.waa.dragons.mediationattendance.domain.Section;
import com.waa.dragons.mediationattendance.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    SectionService sectionService;


    @GetMapping("/getSections")
    public String getSections(Model model){

        model.addAttribute("sections", sectionService.findAll());
        return "sectionList";
    }
}
