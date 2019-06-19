package com.waa.dragons.mediationattendance.batch;


import com.waa.dragons.mediationattendance.domain.Attendance;
import com.waa.dragons.mediationattendance.domain.Block;
import com.waa.dragons.mediationattendance.service.BlockService;
import com.waa.dragons.mediationattendance.service.PlaceService;
import com.waa.dragons.mediationattendance.service.StudentService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class SpecialAttendanceProcessor implements ItemProcessor<SpecialAttendance, Attendance> {
    @Autowired
    private StudentService studentService;

    @Autowired
    private BlockService blockService;

    @Autowired
    private PlaceService placeService;


    @Override
    public Attendance process(SpecialAttendance specialAttendance) throws Exception {
        Attendance attendance = new Attendance();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        attendance.setDate(LocalDate.parse(specialAttendance.getDate(), formatter));


        attendance.setStudent(studentService.findStudentByStudentId(specialAttendance.getStudentId()));

        attendance.setType("AM");

        attendance.setPlace(placeService.findByPlaceId("DB"));

        attendance.setBlock(blockService.findBlockByStartDateLessThanEqualAndEndDateGreaterThanEqual(attendance.getDate(),attendance.getDate()).orElse(new Block()));

        return attendance;
    }
}
