package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Integer> {
}
