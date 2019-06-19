package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.Entry;
import com.waa.dragons.mediationattendance.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

    List<Student> findStudentsByEntry(Entry entry);

    Student findStudentByBarCode(String barCode);

    Student findStudentByStudentId(String studentId);


}
