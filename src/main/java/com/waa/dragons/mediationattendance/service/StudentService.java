package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.Entry;
import com.waa.dragons.mediationattendance.domain.Student;

import java.util.List;

public interface StudentService {



    int getTmRetreats();

    int getTmCheckings();

    int getHowManyDaysLeft();

    Student findStudentByBarCode(String barCode);

    Student findStudentByStudentId(String studentId);

    List<Student> findStudentsByEntry(Entry entry);
    



}
