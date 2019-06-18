package com.waa.dragons.mediationattendance.controller;


import com.waa.dragons.mediationattendance.domain.*;
import com.waa.dragons.mediationattendance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FacultyController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private BlockService blockService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private AttendanceService attendanceService;
@RequestMapping(value = "/faculty/blockList")
public String facultyCourseList(Model model) {

    List<Block> blocks = blockService.findallBlocks();


    model.addAttribute("blockList", blocks);
    return "/facultyReport";
}


    @RequestMapping(value = "/faculty/courseList")
    public String facultyBlock(Model model) {

        List<Course> courses = courseService.findallCourse();

        model.addAttribute("courseList", courses);
        return "/facultyReport";
    }

    @RequestMapping(value = "/faculty/courseList/{id}")
    public String facultyAttendance(@PathVariable Long id, Model model) {

        Attendance attendance = attendanceService.findAttendanceByID(id);

        model.addAttribute("attendances", attendance);
        return "attendance/facultyAttendanceList";
    }

}
