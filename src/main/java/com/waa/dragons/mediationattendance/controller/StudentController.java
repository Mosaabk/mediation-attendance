package com.waa.dragons.mediationattendance.controller;


import com.waa.dragons.mediationattendance.domain.Attendance;
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
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private BlockService blockService;

    @Autowired
    private StudentService studentService;
    @GetMapping("/report")
    public String getReport(){
        return "studentReport";
    }

    @GetMapping("/reportDetails")
    public String getReportDetails(){
        return "reportDetails";
    }


    @GetMapping("/st/{studentId}")
    public String getAttendances(@PathVariable("studentId") String studentId, Model model){
        String blockName="2016-December";
        Block block = blockService.findBlockByBlockName(blockName);
        Student stu = studentService.findStudentByStudentId(studentId);
        model.addAttribute("attendances", attendanceService.findAllByStudent(stu));
        model.addAttribute("stu" ,stu);
        model.addAttribute("blockAttendances", attendanceService.findAllByStudentAndBlock(stu, block));
        return "attendanceList";
    }
        @GetMapping("/{stuId}")
        public String getBlock(@PathVariable("stuId")String studentId,Model model){
        Student stu=studentService.findStudentByStudentId(studentId);
         model.addAttribute("blocks",blockService.getAll());
         model.addAttribute("stu",stu);
        return "attendanceList";
        }
}
