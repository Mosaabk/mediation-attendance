package com.waa.dragons.mediationattendance.repository;


import com.waa.dragons.mediationattendance.domain.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Integer> {
}
