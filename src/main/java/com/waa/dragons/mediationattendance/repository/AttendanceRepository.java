package com.waa.dragons.mediationattendance.repository;


import com.waa.dragons.mediationattendance.domain.Attendance;
import com.waa.dragons.mediationattendance.domain.Block;
import com.waa.dragons.mediationattendance.domain.Entry;
import com.waa.dragons.mediationattendance.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

    List<Attendance> findAllByStudent(Student student);
    List<Attendance> findAllByStudentAndBlockOrderByDate(Student student, Block block);

}
