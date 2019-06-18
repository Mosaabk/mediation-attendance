package com.waa.dragons.mediationattendance.service.impl;

import com.waa.dragons.mediationattendance.domain.Place;
import com.waa.dragons.mediationattendance.repository.PlaceRepository;
import com.waa.dragons.mediationattendance.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceRepository placeRepository;


    @Override
    public Place findByPlaceId(String placeId) {
        return placeRepository.findByPlaceId(placeId);
    }
}
