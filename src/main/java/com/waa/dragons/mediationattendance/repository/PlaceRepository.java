package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer> {

    Place findByPlaceId(String placeId);
}
