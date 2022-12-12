package com.proyectTest.proyectTest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.proyectTest.proyectTest.entity.Dentist;
import com.proyectTest.proyectTest.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentDto {

    private Long id;
    private String date;
    private Patient patient;
    private Dentist dentist;

    public AppointmentDto() {
    }
}
