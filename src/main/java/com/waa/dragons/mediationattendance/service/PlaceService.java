package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.Place;

public interface PlaceService {
    Place findByPlaceId(String placeId);
}
