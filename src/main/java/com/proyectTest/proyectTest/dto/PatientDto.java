package com.proyectTest.proyectTest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.proyectTest.proyectTest.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientDto {

    private Long id;
    private String lastname;
    private String name;
    private String address;
    private String registration_date;

    public PatientDto() {
    }
}
