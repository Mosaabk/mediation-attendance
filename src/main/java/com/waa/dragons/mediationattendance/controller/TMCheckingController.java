package com.waa.dragons.mediationattendance.controller;


import com.waa.dragons.mediationattendance.domain.Student;
import com.waa.dragons.mediationattendance.domain.TMChecking;
import com.waa.dragons.mediationattendance.service.StudentService;
import com.waa.dragons.mediationattendance.service.TMCheckingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/TMChecking")
public class TMCheckingController {
    @Autowired
    TMCheckingService tmCheckingService;
    @Autowired
    StudentService studentService;

    @GetMapping("")
    public String getForm(@ModelAttribute("tMChecking") TMChecking tmChecking, Model model){

//        return "TMCheckingForm";
        return "TMChecking";
    }

    @PostMapping("/addTMChecking")
    public String process(@Valid @ModelAttribute("tMChecking")TMChecking tmChecking, BindingResult result, Model model){
        if(result.hasErrors()){
            return "tmschedule";
        }

     tmCheckingService.save(tmChecking);
        return "redirect:/TMChecking/TMCheckingList";

    }
    @GetMapping("/TMCheckingList")
    public  String TMCheckingList(Model model){
        model.addAttribute("TMCheckingList",tmCheckingService.getAll());
        return "TMCheckingList";
    }
//    @GetMapping("/TMChecking/{id}")
//    public String getTMChecking(@PathVariable int id,Model model){
//
//return
//    }

}
