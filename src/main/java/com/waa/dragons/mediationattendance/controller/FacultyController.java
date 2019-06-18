package com.waa.dragons.mediationattendance.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fac")
public class FacultyController {


    @GetMapping("/TMReport")
    public String getReport(){
        return "TMReport";
    }


}
