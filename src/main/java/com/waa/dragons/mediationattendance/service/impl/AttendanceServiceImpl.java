package com.waa.dragons.mediationattendance.service.impl;
import com.waa.dragons.mediationattendance.domain.*;
import com.waa.dragons.mediationattendance.repository.AttendanceRepository;

import com.waa.dragons.mediationattendance.domain.Attendance;
import com.waa.dragons.mediationattendance.service.AttendanceService;
import com.waa.dragons.mediationattendance.service.BlockService;
import com.waa.dragons.mediationattendance.service.EntryService;
import com.waa.dragons.mediationattendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {


    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EntryService entryService;

    @Autowired
    private BlockService blockService;

    @Override
    public double getTotalAttendancePercentage() {
        return 0;
    }

    @Override
    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> saveAll(List<Attendance> attendances) {
        return null;
    }

    @Override
    public List<Attendance> findAllByStudent(Student student) {
        return  attendanceRepository.findAllByStudent(student);
    }

    @Override
    public List<Attendance> findAllByStudentAndAndBlock(Student student, Block block) {
        return attendanceRepository.findAllByStudentAndAndBlock(student, block);
    }

    @Override
    public List<Attendance> findEntryReport(String entry) {

        List<Student> studentList = studentService.findStudentsByEntry(entryService.findByName(entry));
        EntryReport entryReport = new EntryReport();

        List<Attendance> attendancesByEntry = new ArrayList<>();

        for(Student student : studentList){

           System.out.println(student.getEntry());
           attendancesByEntry.addAll(attendanceRepository.findAllByStudent(student));
           entryReport.setFirstName(student.getFirstName());
           entryReport.setFirstName(student.getLastName());

           HashMap<String, StudentBlockAttendanceReport> blockAttendances = new HashMap<>();

           for(Section section : student.getSections()){

           }

        }

        return  attendancesByEntry;
    }

    public double getExtraPointsByBlock(double percentage) {

        if( percentage >= 0.9) return 1.5;
        else if( percentage > 0.8) return 1.0;
        else if( percentage > 0.7) return 0.5;
        else return 0.0;

    }

    @Override
    public List<StudentBlockAttendanceReport> findAllByBlockIdAndEntryIdReport(int blockId, int entryId) {
        List<Student> students = studentService.findStudentsByEntry(entryService.findById(entryId));
        List<Attendance> attendances = new ArrayList<>();
        List<StudentBlockAttendanceReport> studentBlockAttendancesReportReport = new ArrayList<>();


        for (Student student : students){
            StudentBlockAttendanceReport studentBlockAttendanceReport = new StudentBlockAttendanceReport();
            List<Attendance> attendanceList = attendanceRepository.findAllByStudentAndAndBlock(student, blockService.findById(blockId));
            double percentage = (double) attendanceList.size() / 22;

            studentBlockAttendanceReport.setDaysPresent(attendanceList.size());
            studentBlockAttendanceReport.setDaysAvailable(22);
            studentBlockAttendanceReport.setAttendancePercentage(percentage);
            studentBlockAttendanceReport.setStudentName(student.getFirstName() + " " + student.getLastName());
            studentBlockAttendanceReport.setExtraPoints(getExtraPointsByBlock(percentage));
            studentBlockAttendancesReportReport.add(studentBlockAttendanceReport);
        }

        return studentBlockAttendancesReportReport;
    }

    public int test(){
        return 0;
    }

    @Override
    public List<Attendance> findAllByBlockIdAndEntryId(int blockId, int entryId) {
        List<Student> students = studentService.findStudentsByEntry(entryService.findById(entryId));
        List<Attendance> attendances = new ArrayList<>();


        for (Student student : students){

            attendances.addAll(attendanceRepository.findAllByStudentAndAndBlock(student, blockService.findById(blockId)));
        }




        return attendances;
    }



    public Double getAttendancePercentage(List<Attendance> attendancePerStudent){

        // I need to get how many days available in the block(how many sessions available)


        return 0.0;
    }

}
