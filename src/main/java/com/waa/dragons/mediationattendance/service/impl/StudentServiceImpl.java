package com.waa.dragons.mediationattendance.service.impl;

import com.waa.dragons.mediationattendance.domain.Student;
import com.waa.dragons.mediationattendance.repository.StudentRepository;
import com.waa.dragons.mediationattendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;



    @Override
    public Student findStudentByStudentId(String studentId) {
        return studentRepository.findStudentByStudentId(studentId);
    }


    @Override
    public Student getById(Integer id) {
        return null;
    }

    @Override
    public int getTmRetreats() {
        return 0;
    }

    @Override
    public int getTmCheckings() {
        return 0;
    }

    @Override
    public int getHowManyDaysLeft() {
        return 0;
    }

    @Override
    public Student findStudentByBarCode(String barCode) {
        return studentRepository.findStudentByBarCode(barCode);
    }

}
