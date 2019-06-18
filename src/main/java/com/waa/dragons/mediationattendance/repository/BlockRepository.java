package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.Block;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Optional;


@Repository
public interface BlockRepository extends CrudRepository<Block, Integer> {

    Block findBlockByBlockName(String name);
    Optional<Block> findBlockByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate startDate, LocalDate endDate);
}
