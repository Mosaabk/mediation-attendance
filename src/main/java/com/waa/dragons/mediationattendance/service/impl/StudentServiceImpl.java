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
    public double getTotalPercentage() {

        return 0;
    }

=======
    @Override
    public Student getById(Integer id) {
        return studentRepository.getOne(id);


    }

>>>>>>> 1a9eb7e425d73ea27c783219fda16353a959ae75
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
<<<<<<< HEAD
    public Student getById(int id) {
        return null;
    }

    @Override
    public Student findStudentByStudentId(String studentId) {
      return studentRepository.findStudentByStudentId(studentId);
    }

    public Student findStudentByBarCode(String barCode){
        return studentRepository.findStudentByBarCode(barCode);

    }

    public Student findStudentByStudentId(Long studentId){
        return null;
    }



=======
    public Student findStudentByBarCode(String barCode) {
        return null;
    }

>>>>>>> 1a9eb7e425d73ea27c783219fda16353a959ae75
}
