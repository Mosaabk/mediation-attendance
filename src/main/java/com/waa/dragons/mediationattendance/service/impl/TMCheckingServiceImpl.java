package com.waa.dragons.mediationattendance.service.impl;

import com.waa.dragons.mediationattendance.domain.TMChecking;
import com.waa.dragons.mediationattendance.repository.TMCheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TMCheckingServiceImpl {

    @Autowired
    TMCheckingRepository tmCheckingRepository;

    public TMChecking save(TMChecking checking){
        return tmCheckingRepository.save(checking);
    }
}
