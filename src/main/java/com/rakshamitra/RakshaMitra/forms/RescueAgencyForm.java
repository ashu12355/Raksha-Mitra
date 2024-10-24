package com.rakshamitra.RakshaMitra.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RescueAgencyForm {

    private String agencyName;
    private String contactPersonName;
    private String contactNumber;
    private String email;
    private String password;
    private String agencyLocation;
    private double latitude;
    private double longitude;
    private String specialization;
    private int teamSize;
    private String availability;
    private String description;
    private boolean approved;
}
