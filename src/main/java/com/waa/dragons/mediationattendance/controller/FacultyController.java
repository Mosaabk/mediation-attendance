package com.waa.dragons.mediationattendance.controller;


import com.waa.dragons.mediationattendance.domain.*;
import com.waa.dragons.mediationattendance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private SectionService sectionService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private EntryService entryService;

    @Autowired
    private FacultyService facultyService;



    @GetMapping("/report")
    public String getTmForm(Model model, @RequestParam(value = "entryId",required = false) Integer entryId,
                            @RequestParam(value = "blockId", required = false) Integer blockId){

        model.addAttribute("entries", entryService.findAll());
        System.out.println("this is the block id " + blockId);
        if(entryId != null){
            List<Attendance> attendances = new ArrayList<>();
            if(blockId != null && blockId !=0){
                model.addAttribute("report",attendanceService.findAllByBlockIdAndEntryIdReport(blockId, entryId));
            } else {
                attendances = attendanceService.findEntryReport(entryService.findById(entryId).getName());
            }

            model.addAttribute("attendanceList", attendances);

        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String facultyName = auth.getName();


        Faculty faculty = facultyService.findFacultyByUsername(facultyName);


        model.addAttribute("blocks", sectionService.findAllByFaculty(faculty));

        model.addAttribute("firstName", faculty.getName());


        model.addAttribute("currentBlock", "July");
        model.addAttribute("sessionInBlock", "22");
        model.addAttribute("daysPresent", "21");
        model.addAttribute("currentBlockPercentage", "92%");
        model.addAttribute("bonusMark", "1.5");


        return "facultyReport";
    }


    @RequestMapping(value = "/faculty/courseList")
    public String facultyBlock(Model model) {


        model.addAttribute("courseList", blockService.findAll());
        return "/facultyReport";
    }

    @RequestMapping(value = "/faculty/courseList/{id}")
    public String facultyAttendance(@PathVariable Long id, Model model) {

        List<Attendance> attendance = attendanceService.findAllById(id);

        model.addAttribute("attendances", attendance);
        return "attendance/facultyAttendanceList";
    }

}