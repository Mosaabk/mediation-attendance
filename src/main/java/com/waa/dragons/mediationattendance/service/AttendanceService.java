package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.*;

import java.util.List;

public interface AttendanceService {

    double getTotalAttendancePercentage();

    Attendance save(Attendance attendance);
    List<Attendance> saveAll(List<Attendance> attendances);
    List<Attendance> findAllByStudent(Student student);
    List<Attendance> findAllByStudentAndAndBlock(Student student, Block block);

    List<Attendance> findEntryReport(String entry);


    List<Attendance> findAllByBlockIdAndEntryId(int blockId, int entryId);
    List<StudentBlockAttendanceReport> findAllByBlockIdAndEntryIdReport(int blockId, int entryId);

}
