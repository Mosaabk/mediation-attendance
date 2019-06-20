package com.waa.dragons.mediationattendance.batch;


import com.waa.dragons.mediationattendance.domain.Attendance;
import com.waa.dragons.mediationattendance.repository.AttendanceRepository;
import com.waa.dragons.mediationattendance.service.AttendanceService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbDefaultWriter implements ItemWriter<Attendance> {

    @Autowired
    private AttendanceService attendanceService;


    @Override
    public void write(List<? extends Attendance> attendances) throws Exception {
        for(Attendance attendance : attendances){
            attendanceService.save(attendance);
        }

    }




}
