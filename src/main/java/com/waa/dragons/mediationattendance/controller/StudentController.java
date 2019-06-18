package com.waa.dragons.mediationattendance.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stu")
public class StudentController {

    @GetMapping("/report")
    public String getReport(){
        return "studentReport";
    }

    @GetMapping("/reportDetails")
    public String getReportDetails(){
        return "reportDetails";
    }

}
