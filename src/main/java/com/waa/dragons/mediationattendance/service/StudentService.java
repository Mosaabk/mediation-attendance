package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.Student;

public interface StudentService {



    Student getById(Integer id);
    int getTmRetreats();

    int getTmCheckings();

    int getHowManyDaysLeft();


    Student findStudentByBarCode(String barCode);



}
