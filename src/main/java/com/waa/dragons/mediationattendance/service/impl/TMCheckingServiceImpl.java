package com.waa.dragons.mediationattendance.service.impl;

import com.waa.dragons.mediationattendance.domain.TMChecking;
import com.waa.dragons.mediationattendance.repository.TMCheckingRepository;
import com.waa.dragons.mediationattendance.service.TMCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TMCheckingServiceImpl implements TMCheckingService {
    @Autowired
    TMCheckingRepository tmCheckingRepository;
    @Override
    public TMChecking save(TMChecking checking) {
        return tmCheckingRepository.save(checking);
    }

    @Override
    public TMChecking update(TMChecking checking) {
        return tmCheckingRepository.save(checking);
    }

    @Override
    public List<TMChecking> getAll() {

        return (List<TMChecking>)tmCheckingRepository.findAll();
    }

    @Override
    public TMChecking getById(int id) {
        return tmCheckingRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        tmCheckingRepository.deleteById(id);

    }




}
