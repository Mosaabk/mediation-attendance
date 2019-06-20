package com.waa.dragons.mediationattendance.controller;


import com.waa.dragons.mediationattendance.domain.Block;
import com.waa.dragons.mediationattendance.domain.Student;
import com.waa.dragons.mediationattendance.service.AttendanceService;
import com.waa.dragons.mediationattendance.service.BlockService;
import com.waa.dragons.mediationattendance.service.SectionService;
import com.waa.dragons.mediationattendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    SectionService sectionService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private BlockService blockService;

    @GetMapping("/report")
    public String getReport(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String studentId = auth.getName();
        System.out.println("username " + auth.getName());

        if(studentId == null)  studentId = "987174";
        Student student = studentService.findStudentByStudentId(studentId);

        model.addAttribute("student", student);
        model.addAttribute("studentReport",  attendanceService.findAllByStudentIdReport(studentId));
        model.addAttribute("currentBlock", "2016-December");

        model.addAttribute("blocks", sectionService.findAllByStudentList_studentId(studentId));

        Block block = blockService.findBlockByBlockName("2016-December");

        model.addAttribute("stuBlockAttendReport",attendanceService.getAttendanceByBlockReport(student,block.getId()));

        model.addAttribute("blockDays", attendanceService.getAllBlockPresentDays(student,block));


        return "studentReport";
    }

    @GetMapping("/reportDetails")
    public String getReportDetails(){
        return "reportDetails";
    }

    @GetMapping("/{studentId}")
    public String getAttendanceList(@PathVariable("studentId") String studentId, Model model){
        Student student = studentService.findStudentByStudentId(studentId);
        Block block = blockService.findBlockByBlockName("2016-December");
        model.addAttribute("stu", student);
        model.addAttribute("attendances", attendanceService.findAllByStudent(student));
        model.addAttribute("blockAttendances",attendanceService.findAllByStudentAndAndBlock(student,block));

        return "attendanceList";
    }

}
