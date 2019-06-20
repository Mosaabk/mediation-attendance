package com.waa.dragons.mediationattendance.service.impl;

import com.waa.dragons.mediationattendance.domain.Faculty;
import com.waa.dragons.mediationattendance.repository.FacultyRepository;
import com.waa.dragons.mediationattendance.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;


    @Override
    public Faculty findFacultyByUsername(String name) {
        return facultyRepository.findFacultyByUsername(name);
    }
}
