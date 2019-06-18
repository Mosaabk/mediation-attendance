<<<<<<< HEAD
package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.TMChecking;

import java.util.List;

public interface TMCheckingService {

   public  TMChecking save(TMChecking checking);
   public TMChecking update(TMChecking checking);
   public List<TMChecking> getAll();
   public TMChecking getById(int id);
   public void delete(int id);



}
=======
package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.TMChecking;

public interface TMCheckingService {

    TMChecking save(TMChecking checking);
}
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
