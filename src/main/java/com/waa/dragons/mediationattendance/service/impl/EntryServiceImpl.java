package com.waa.dragons.mediationattendance.service.impl;

import com.waa.dragons.mediationattendance.domain.Entry;
import com.waa.dragons.mediationattendance.repository.EntryRepository;
import com.waa.dragons.mediationattendance.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepository;


    @Override
    public Entry findById(int id) {
        return entryRepository.findById(id);
    }

    @Override
    public Entry findByName(String name) {
        return entryRepository.findByName(name);
    }

    @Override
    public List<Entry> findAll() {
        return entryRepository.findAll();
    }
}
