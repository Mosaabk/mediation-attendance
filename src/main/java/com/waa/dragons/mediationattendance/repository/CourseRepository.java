package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
}
