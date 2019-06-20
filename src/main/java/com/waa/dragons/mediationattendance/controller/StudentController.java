package com.waa.dragons.mediationattendance.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("report")
    public String getReport(Model model) {

        int totalSessionsPossible = 95;
        int totalSessionsAttainded = 80;
        int percentAttainded = totalSessionsAttainded * 100 / totalSessionsPossible;
        int totalRemaining = (totalSessionsPossible * 60 / 100) - (totalSessionsAttainded);

        model.addAttribute("totalSessionsPossible", totalSessionsPossible);
        model.addAttribute("totalSessionsAttainded", totalSessionsAttainded);
        model.addAttribute("percentAttainded", percentAttainded);
        model.addAttribute("totalRemaining", totalRemaining);


        String currentBlock = "July";
        int sessionInBlock = 22;
        int daysPresent = 22;
        int currentBlockPercentage = daysPresent / sessionInBlock * 100;
        double bonusMark = ((currentBlockPercentage > 90) ? 1.5 : (currentBlockPercentage > 85 ? 1.0 : (currentBlockPercentage > 80 ? 1.0 : 0.0)));

        model.addAttribute("currentBlock", currentBlock);
        model.addAttribute("sessionInBlock", sessionInBlock);
        model.addAttribute("daysPresent", daysPresent);
        model.addAttribute("currentBlockPercentage", currentBlockPercentage);
        model.addAttribute("bonusMark", bonusMark);


        List<String> operators = Arrays.asList("22-June", "23-June", "24-June", "25-June", "26-June", "27-June");
        model.addAttribute("operators", operators);

        model.addAttribute("firstName", "Abdu");

        return "studentReport";
    }



    @GetMapping("/reportDetails")
    public String getReportDetails(){
        return "reportDetails";
    }

}
