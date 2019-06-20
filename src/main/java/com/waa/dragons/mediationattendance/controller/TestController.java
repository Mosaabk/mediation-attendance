package com.waa.dragons.mediationattendance.controller;


import com.waa.dragons.mediationattendance.domain.*;
import com.waa.dragons.mediationattendance.service.AttendanceService;
import com.waa.dragons.mediationattendance.service.BlockService;
import com.waa.dragons.mediationattendance.service.SectionService;
import com.waa.dragons.mediationattendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    SectionService sectionService;
    @Autowired
    AttendanceService attendanceService;

    @Autowired
    StudentService studentService;

    @Autowired
    BlockService blockService;


    @GetMapping("/getSections/{stuId}")
    public String getSections(@PathVariable("stuId") String studentId, Model model){

        System.out.println(studentId);
        Student student = studentService.findStudentByStudentId(studentId);

        model.addAttribute("student", student);
        model.addAttribute("studentReport",  attendanceService.findAllByStudentIdReport(studentId));

        model.addAttribute("blocks", sectionService.findAllByStudentList_studentId(studentId));

        Block block = blockService.findBlockByBlockName("2016-December");


        model.addAttribute("stuBlockAttendReport",attendanceService.getAttendanceByBlockReport(student,block.getId()));
        model.addAttribute("blockDays", attendanceService.getAllBlockPresentDays(student,block));
        return "sectionList";
    }
}
