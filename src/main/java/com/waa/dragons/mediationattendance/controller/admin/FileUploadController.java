package com.waa.dragons.mediationattendance.controller.admin;

import com.waa.dragons.mediationattendance.domain.Attendance;
import com.waa.dragons.mediationattendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileUploadController {

    private AttendanceService attendanceService;

    @Autowired
    public FileUploadController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/uploadData")
    public String getDataForm(){
        return "dataForm";
    }

}
