<<<<<<< HEAD
package com.waa.dragons.mediationattendance.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fac")
public class FacultyController {


    @GetMapping("/TMReport")
    public String getReport(){
        return "TMReport";
    }


}
=======
package com.waa.dragons.mediationattendance.controller;


import org.springframework.stereotype.Controller;

@Controller
public class FacultyController {
}
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
