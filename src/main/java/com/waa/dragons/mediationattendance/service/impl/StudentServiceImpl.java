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

<<<<<<< HEAD
    @Override
    public Student getById(Integer id) {
        return studentRepository.getOne(id);
=======

    public Student getByID(Integer id) {
        // TODO Auto-generated method stub
        return studentRepository.getOne(id);
    }

    public Student findStudentByBarCode(String barCode){
        return studentRepository.findStudentByBarCode(barCode);
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
    }


    @Override
    public int getTmRetreats()
    {
        return 0;
    }

    @Override
    public int getTmCheckings()
    {
        return 0;
    }

    @Override
    public int getHowManyDaysLeft() {
        return 0;
    }
}
