package com.waa.dragons.mediationattendance.controller;

import com.waa.dragons.mediationattendance.domain.TMRetreat;
import com.waa.dragons.mediationattendance.service.TMRetreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/tmretreat")
public class TMRetreatController {
    @Autowired
    TMRetreatService tmRetreatService;

    @GetMapping("")
    public String getRetreatForm(@ModelAttribute("tmRetreat")TMRetreat tmRetreat, Model model){
        return "TMRetreat";
    }
    @PostMapping("/addRetreat")
    public String processRetreat(@Valid@ModelAttribute("tmretreat")TMRetreat tmRetreat, BindingResult result,Model model){
        if(result.hasErrors()){
            return "RetreatForm2";
        }


        tmRetreatService.save(tmRetreat);
        return "redirect:/retreat/tmRetreatList";
    }
    @GetMapping("/tmRetreatList")
    public String retreatList(Model model){
        model.addAttribute("Retreats",tmRetreatService.getAll());
        return "TMRetreatList";
    }

    @GetMapping("/tmRetreat/{id}")
    public String getRetreat(@PathVariable int id,Model model){

        return null;
    }

}