package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.TMRetreat;

import java.util.List;

public interface TMRetreatService {


    public  TMRetreat save(TMRetreat retreat);
    public TMRetreat update(TMRetreat retreat);
    public List<TMRetreat> getAll();
    public TMRetreat getById(int id);
    public void delete(int id);
}
