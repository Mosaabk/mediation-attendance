package com.waa.dragons.mediationattendance.service.impl;

import com.waa.dragons.mediationattendance.domain.Student;
import com.waa.dragons.mediationattendance.repository.StudentRepository;
import com.waa.dragons.mediationattendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
<<<<<<< HEAD
@Autowired
    StudentRepository studentRepository;

    public double getTotalPercentage() {
        return 0;
    }

    @Override
    public int getTmRetreats() {
        return 0;
    }

    @Override
    public int getTmCheckings() {
=======

    @Autowired
    private StudentRepository studentRepository;


    public Student getByID(Integer id) {
        // TODO Auto-generated method stub
        return studentRepository.getOne(id);
    }

    public Student findStudentByBarCode(String barCode){
        return studentRepository.findStudentByBarCode(barCode);
    }


    @Override
    public int getTmRetreats()
    {
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
        return 0;
    }

    @Override
<<<<<<< HEAD
    public int getHowManyDaysLeft() {
=======
    public int getTmCheckings()
    {
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
        return 0;
    }

    @Override
<<<<<<< HEAD
    public Student getById( int id) {
        return  studentRepository.findById(id).get();
=======
    public int getHowManyDaysLeft() {
        return 0;
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
    }
}
