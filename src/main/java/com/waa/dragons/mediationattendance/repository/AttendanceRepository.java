<<<<<<< HEAD
package com.waa.dragons.mediationattendance.repository;


import com.waa.dragons.mediationattendance.domain.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Integer> {
}
=======
package com.waa.dragons.mediationattendance.repository;


import com.waa.dragons.mediationattendance.domain.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
}
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
