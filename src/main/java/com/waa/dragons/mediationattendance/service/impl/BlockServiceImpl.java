package com.waa.dragons.mediationattendance.service.impl;

import com.waa.dragons.mediationattendance.domain.Block;
import com.waa.dragons.mediationattendance.repository.BlockRepository;
import com.waa.dragons.mediationattendance.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    BlockRepository blockRepository;


    @Override
    public Block findBlockByBlockName(String name) {
        return blockRepository.findBlockByBlockName(name);
    }

//    @Override
//    public Optional<Block> findBlockByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate startDate, LocalDate endDate) {
//        return blockRepository.findBlockByStartDateLessThanEqualAndEndDateGreaterThanEqual(startDate,endDate);
//
//    }

    @Override
    public Optional<Block> findBlockByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate startDate, LocalDate endDate) {
        return Optional.empty();
    }

    public String test(){
        return null;
    }

    @Override
    public List<Block> findAll() {
        return blockRepository.findAll();
    }

    @Override
    public Block findById(Integer blockId) {
        return blockRepository.findById(blockId).orElse(new Block());
    }

    @Override
    public List<Block> findAllById(Integer blockId) {
        return blockRepository.findAllById(blockId);
    }
}
