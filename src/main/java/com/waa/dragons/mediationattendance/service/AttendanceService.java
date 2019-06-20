package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AttendanceService {

    double getTotalAttendancePercentage();

    Attendance save(Attendance attendance);
    List<Attendance> saveAll(List<Attendance> attendances);
    List<Attendance> findAllByStudent(Student student);
    List<Attendance> findAllByStudentAndAndBlock(Student student, Block block);

    List<Attendance> findEntryReport(String entry);

    List<Attendance> findAllByBlockIdAndEntryId(int blockId, int entryId);

    List<StudentBlockAttendanceReport> findAllByBlockIdAndEntryIdReport(int blockId, int entryId);
    TotalStudentAttendanceReport findAllByStudentIdReport(String studentId);
    StudentBlockAttendanceReport getAttendanceByBlockReport(Student student,int blockId);


    Map<LocalDate,Boolean> getAllBlockPresentDays(Student student, Block block);


}
