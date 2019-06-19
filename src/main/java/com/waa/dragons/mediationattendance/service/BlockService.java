package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.Block;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface BlockService {
    Block findBlockByBlockName(String name);

    Optional<Block> findBlockByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate startDate, LocalDate endDate);

    List<Block> findAll();

    Block findById(Integer blockId);

    List<Block> findAllById(Integer blockId);
}
