package com.waa.dragons.mediationattendance.batch;


import com.waa.dragons.mediationattendance.domain.Attendance;
import com.waa.dragons.mediationattendance.repository.AttendanceRepository;
import com.waa.dragons.mediationattendance.service.AttendanceService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Attendance> {

    @Autowired
    private AttendanceService attendanceService;


    @Override
    public void write(List<? extends Attendance> attendances) throws Exception {
        System.out.println("Data Saved for Attendance " + attendances);
        attendanceService.saveAll((List<Attendance>)attendances);

    }




}
