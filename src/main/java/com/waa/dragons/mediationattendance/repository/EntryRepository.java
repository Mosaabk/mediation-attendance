package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.Entry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntryRepository extends CrudRepository<Entry, Integer> {

    Entry findById(int id);
    Entry findByName(String name);
    List<Entry> findAll();
    String test();
}
