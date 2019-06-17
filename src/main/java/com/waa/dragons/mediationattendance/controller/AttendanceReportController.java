package com.waa.dragons.mediationattendance.controller;

import com.waa.dragons.mediationattendance.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AttendanceReportController {

    @GetMapping("/studentreport")
    public String showStudentReport(Model model){

        Student student = new Student();
        //student.
        return "studentreportdisplay";
    }
}
