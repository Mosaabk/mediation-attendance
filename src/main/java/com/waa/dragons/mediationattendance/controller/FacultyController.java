package com.waa.dragons.mediationattendance.controller;


import com.waa.dragons.mediationattendance.domain.*;
import com.waa.dragons.mediationattendance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

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

    @Autowired
    private EntryService entryService;



    @GetMapping("/report")
    public String getTmForm(Model model, @RequestParam(value = "entryId",required = false) Integer entryId,
                            @RequestParam(value = "blockId", required = false) Integer blockId){
        model.addAttribute("entries", entryService.findAll());

        if(entryId != null){
            List<Attendance> attendances = new ArrayList<>();
            if(blockId != null){
                model.addAttribute("report",attendanceService.findAllByBlockIdAndEntryIdReport(blockId, entryId));
            } else {
                attendances = attendanceService.findEntryReport(entryService.findById(entryId).getName());
            }

            model.addAttribute("attendanceList", attendances);

        }
        model.addAttribute("blocks", blockService.findAll());



        model.addAttribute("firstName", "Tina");


        model.addAttribute("currentBlock", "July");
        model.addAttribute("sessionInBlock", "22");
        model.addAttribute("daysPresent", "21");
        model.addAttribute("currentBlockPercentage", "92%");
        model.addAttribute("bonusMark", "1.5");


        return "facultyReport";
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
