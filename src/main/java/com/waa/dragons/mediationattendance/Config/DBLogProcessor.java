package com.waa.dragons.mediationattendance.Config;

import com.waa.dragons.mediationattendance.domain.Attendance;
import org.springframework.batch.item.ItemProcessor;

public class DBLogProcessor implements ItemProcessor<Attendance, Attendance> {
    public  Attendance process(Attendance attendance) throws Exception {
        System.out.println("Insert Attendance : " + attendance);
        return attendance;
    }
}
