package com.waa.dragons.mediationattendance.service.impl;


import com.waa.dragons.mediationattendance.domain.TMRetreat;
import com.waa.dragons.mediationattendance.repository.TMRetreatRepository;
import com.waa.dragons.mediationattendance.service.TMRetreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TMRetreatServiceImpl implements TMRetreatService {
    @Autowired
    TMRetreatRepository tmRetreatRepository;
    @Override
    public TMRetreat save(TMRetreat retreat) {
        return tmRetreatRepository.save(retreat);
    }

    @Override
    public TMRetreat update(TMRetreat retreat) {
        return tmRetreatRepository.save(retreat);
    }

    @Override
    public List<TMRetreat> getAll() {
        return (List<TMRetreat>)tmRetreatRepository.findAll();
    }

    @Override
    public TMRetreat getById(int id) {
        return tmRetreatRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        tmRetreatRepository.deleteById(id);

    }
}
