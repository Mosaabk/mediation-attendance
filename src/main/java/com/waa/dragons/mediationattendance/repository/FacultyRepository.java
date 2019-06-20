package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.Faculty;
import org.springframework.data.repository.CrudRepository;

public interface FacultyRepository extends CrudRepository<Faculty, Long> {

    Faculty findFacultyByUsername(String name);
}

