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
public class DefaultAttendanceProcessor implements ItemProcessor<DefaultAttendance, Attendance> {

    @Autowired
    private StudentService studentService;

    @Autowired
    private BlockService blockService;

    @Autowired
    private PlaceService placeService;


    @Override
    public Attendance process(DefaultAttendance defaultAttendance) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");

        Attendance attendance = new Attendance();

        attendance.setDate(LocalDate.parse(defaultAttendance.getDate(), formatter));

        attendance.setStudent(studentService.findStudentByBarCode(defaultAttendance.getBarCode()));

        attendance.setType(defaultAttendance.getType());

        attendance.setPlace(placeService.findByPlaceId(defaultAttendance.getLocation()));

        attendance.setBlock(blockService.findBlockByStartDateLessThanEqualAndEndDateGreaterThanEqual(attendance.getDate(),attendance.getDate()).orElse(new Block()));


        return attendance;

    }
}
