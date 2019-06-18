package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

    Student findStudentByStudentId(String studentId);
//    Student getOne(Integer id);

    Student findStudentByBarCode(String barCode);
}
