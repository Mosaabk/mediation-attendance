package com.waa.dragons.mediationattendance.batch;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultAttendance {

    private String barCode;
    private String date;
    private String type;
    private String location;
}
