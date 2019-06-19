package com.waa.dragons.mediationattendance.service.impl;

import com.waa.dragons.mediationattendance.domain.Section;
import com.waa.dragons.mediationattendance.repository.SectionRepository;
import com.waa.dragons.mediationattendance.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    SectionRepository sectionRepository;


    @Override
    public List<Section> findAll() {
        return sectionRepository.findAll();
    }
}
