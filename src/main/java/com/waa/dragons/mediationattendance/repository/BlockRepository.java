package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.Block;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlockRepository extends CrudRepository<Block, Integer> {
}
