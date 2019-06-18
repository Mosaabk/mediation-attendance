package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.Student;

public interface StudentService {



    int getTmRetreats();

    int getTmCheckings();

    int getHowManyDaysLeft();
    public Student getById(int id);

    Student findStudentByStudentId(String studentId);

    Student findStudentByBarCode(String barCode);



}
