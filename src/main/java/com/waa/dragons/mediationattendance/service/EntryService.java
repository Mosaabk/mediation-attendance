package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.Entry;

import java.util.List;

public interface EntryService {

    Entry findById(int id);
    Entry findByName(String name);
    List<Entry> findAll();


}
