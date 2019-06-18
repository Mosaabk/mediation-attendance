<<<<<<< HEAD
package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.Student;

public interface StudentService {



    int getTmRetreats();

    int getTmCheckings();

    int getHowManyDaysLeft();
    public Student getById(int id);


}
=======
package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.Student;

public interface StudentService {



    int getTmRetreats();

    int getTmCheckings();

    int getHowManyDaysLeft();


    Student findStudentByBarCode(String barCode);



}
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
