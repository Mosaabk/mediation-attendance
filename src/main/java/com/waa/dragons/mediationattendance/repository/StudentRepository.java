<<<<<<< HEAD
package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

    Student getOne(Integer id);
}
=======
package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

    Student getOne(Integer id);
    Student findStudentByBarCode(String barCode);
}
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
