package com.waa.dragons.mediationattendance.repository;


import com.waa.dragons.mediationattendance.domain.Attendance;
import com.waa.dragons.mediationattendance.domain.Block;
import com.waa.dragons.mediationattendance.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
    List<Attendance> findAllByStudentAndBlock(Student stu, Block block);
    List<Attendance> findAllByStudent(Student stu);

}
