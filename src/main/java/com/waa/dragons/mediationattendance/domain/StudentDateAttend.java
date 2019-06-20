package com.waa.dragons.mediationattendance.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDateAttend {

    private LocalDate date;
    private boolean isPresent;
}
