package com.waa.dragons.mediationattendance.controller;


import com.waa.dragons.mediationattendance.domain.Attendance;
import com.waa.dragons.mediationattendance.service.AttendanceService;
import com.waa.dragons.mediationattendance.service.BlockService;
import com.waa.dragons.mediationattendance.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EntryReportController {

    @Autowired
    AttendanceService attendanceService;
    @Autowired
    EntryService entryService;
    @Autowired
    BlockService blockService;


    @GetMapping("/getEntryReport")
    public String getEntryReport(Model model, @RequestParam(value = "entryId",required = false) Integer entryId,
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

        return "entryReport";
    }
}
