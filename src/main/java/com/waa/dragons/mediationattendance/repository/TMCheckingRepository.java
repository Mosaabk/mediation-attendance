package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.TMChecking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TMCheckingRepository extends CrudRepository<TMChecking, Integer> {
}
