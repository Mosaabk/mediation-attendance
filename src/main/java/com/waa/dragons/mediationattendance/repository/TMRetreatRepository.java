package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.TMRetreat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TMRetreatRepository extends CrudRepository<TMRetreat, Integer> {
}
