package com.waa.dragons.mediationattendance.controller;



import com.waa.dragons.mediationattendance.domain.Block;
import com.waa.dragons.mediationattendance.domain.Student;
import com.waa.dragons.mediationattendance.service.AttendanceService;
import com.waa.dragons.mediationattendance.service.BlockService;
import com.waa.dragons.mediationattendance.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private AttendanceReportController attendanceReportController;
    @Autowired
    private StudentService studentService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private BlockService blockService;

    @GetMapping("/report")
    public String getReport(){
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
