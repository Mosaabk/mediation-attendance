package com.waa.dragons.mediationattendance.service.impl;
import com.waa.dragons.mediationattendance.domain.*;
import com.waa.dragons.mediationattendance.repository.AttendanceRepository;

import com.waa.dragons.mediationattendance.domain.Attendance;
import com.waa.dragons.mediationattendance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

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

    @Autowired
    private SectionService sectionService;

    @Override
    public Attendance findAttendanceByID(Long id) {
        return null;
    }

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
        return attendanceRepository.findAllByStudentAndBlockOrderByDate(student, block);
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
            studentBlockAttendancesReportReport.add(getAttendanceByBlockReport(student, blockId));
        }

        return studentBlockAttendancesReportReport;
    }


    public int getDaysAvailableInBlock(List<Section> sections, int blockId){

        for (Section section : sections ){
            if(section.getBlock().getId() == blockId)
                return section.getBlock().getBlockDays();
        }

        return 22;
    }
    @Override
    public TotalStudentAttendanceReport findAllByStudentIdReport(String studentId) {

        TotalStudentAttendanceReport report = new TotalStudentAttendanceReport();

        List<Attendance> attendances = findAllByStudent(studentService.findStudentByStudentId(studentId));

        report.setTotalSessionsAttended(attendances.size());

        List<Section> sections = sectionService.findAllByStudentList_studentId(studentId);

        int totalAttended = attendances.size();
        int totalPossible = getTotalPossible(sections);

        report.setTotalSessionsPossible(totalPossible);

        report.setTotalAttendancePercentage((double) totalAttended / totalPossible);



        return report;
    }

    @Override
    public StudentBlockAttendanceReport getAttendanceByBlockReport(Student student, int blockId) {
        StudentBlockAttendanceReport studentBlockAttendanceReport = new StudentBlockAttendanceReport();
        List<Attendance> attendanceList = attendanceRepository.findAllByStudentAndBlockOrderByDate(student, blockService.findById(blockId));
        int  daysAvailable  = getDaysAvailableInBlock(student.getSections(), blockId);
        double percentage = (double) attendanceList.size() / daysAvailable;


        studentBlockAttendanceReport.setDaysPresent(attendanceList.size());
        studentBlockAttendanceReport.setDaysAvailable(daysAvailable);
        studentBlockAttendanceReport.setAttendancePercentage(percentage);
        studentBlockAttendanceReport.setStudentName(student.getFirstName() + " " + student.getLastName());
        studentBlockAttendanceReport.setExtraPoints(getExtraPointsByBlock(percentage));

        return studentBlockAttendanceReport;
    }

    @Override
    public Map<LocalDate, Boolean> getAllBlockPresentDays(Student student,Block block) {
        Map<LocalDate, Boolean> daysInBlock = new HashMap<>();

        LocalDate startDate = block.getStartDate();
        LocalDate endDate = startDate.plusDays(block.getBlockDays());
        List<Attendance> attendanceList = attendanceRepository.findAllByStudentAndBlockOrderByDate(student, block);

        System.out.println(startDate);
        System.out.println(endDate);

        int i = 0;
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
        {


            if( !(attendanceList.get(i).getDate().getDayOfWeek() == DayOfWeek.SUNDAY) && date.getDayOfWeek() != DayOfWeek.SUNDAY){
                System.out.println("attendDay : " + attendanceList.get(i).getDate());
                System.out.println(date);
                if(date.equals(attendanceList.get(i).getDate())){
                    daysInBlock.put(date, true);
                    i++;
                }
                else
                    daysInBlock.put(date, false);


            }



        }


        return daysInBlock;

    }

    public int getTotalPossible(List<Section> sections){
        int totalDays = 0;

        for (Section section : sections)
            totalDays +=  section.getBlock().getBlockDays();

        return totalDays;
    }

    @Override
    public List<Attendance> findAllByBlockIdAndEntryId(int blockId, int entryId) {
        List<Student> students = studentService.findStudentsByEntry(entryService.findById(entryId));
        List<Attendance> attendances = new ArrayList<>();


        for (Student student : students){

            attendances.addAll(attendanceRepository.findAllByStudentAndBlockOrderByDate(student, blockService.findById(blockId)));
        }




        return attendances;
    }



    public Double getAttendancePercentage(List<Attendance> attendancePerStudent){

        // I need to get how many days available in the block(how many sessions available)


        return 0.0;
    }

}
