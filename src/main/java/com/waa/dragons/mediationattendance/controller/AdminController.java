package com.waa.dragons.mediationattendance.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @GetMapping("/")
    public String getAdminPage(){
        return "adminRetreat";
    }

    @GetMapping("/adminTmchecking")
    public String getTmForm(){
        return "tmForm";
    }

    @PostMapping("/add/tmChecking")
    public String proccesTmForm(){

        // PRG
        return "redirect:/admin/tmList";
    }


    @GetMapping("/tmRetreat")
    public String getTmRetreatForm(){
        return "tmRetreatForm";
    }


    @PostMapping("/add/tmRetreat")
    public String processTmRetreatForm(){

        //RRG
        return "redirect/admin/trList";
    }




}
