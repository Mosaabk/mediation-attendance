package com.waa.dragons.mediationattendance.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {



    @GetMapping("")
    public String getAdminPage(){
        System.out.println("admin");
        return "admin";
    }


    @GetMapping("/tmchecking")
    public String getTmForm(){
        return "tmForm";
    }

    @PostMapping("/add/tmChecking")
    public String proccessTmForm(){

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
