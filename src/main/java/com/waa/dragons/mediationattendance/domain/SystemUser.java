<<<<<<< HEAD
package com.waa.dragons.mediationattendance.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class SystemUser {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;

    private String password;


    @OneToMany
    List<Role> roles;



}
=======
package com.waa.dragons.mediationattendance.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class SystemUser {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;

    private String password;


    @OneToMany
    List<Role> roles;



}
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
