package com.waa.dragons.mediationattendance.controller;


import com.waa.dragons.mediationattendance.domain.*;
import com.waa.dragons.mediationattendance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private BlockService blockService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private AttendanceService attendanceService;



    @GetMapping("/report")
    public String getTmForm(Model model) {

        Map<String, List<Integer>> students = new HashMap<>();

        students.put("Abdu", Arrays.asList(22, 10, 12, 45));
        students.put("Selome", Arrays.asList(22, 22, 0, 100));
        students.put("Semhar", Arrays.asList(22, 21, 1, 95));
        students.put("Mossab", Arrays.asList(22, 20, 0, 89));

        model.addAttribute("students",students);



        int totalSessionsPossible = 95;
        int totalSessionsAttainded = 80;
        int percentAttainded = totalSessionsAttainded*100/totalSessionsPossible;
        int totalRemaining =  (totalSessionsPossible*60/100) - (totalSessionsAttainded);

        model.addAttribute("totalSessionsPossible", totalSessionsPossible);
        model.addAttribute("totalSessionsAttainded", totalSessionsAttainded);
        model.addAttribute("percentAttainded", percentAttainded);
        model.addAttribute("totalRemaining", totalRemaining);



        model.addAttribute("firstName", "Tina");


        return "facultyReport";
    }


    @RequestMapping(value = "/faculty/{id}")
public String facultyCourseList(@PathVariable("id") Faculty faculty, Model model) {

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
