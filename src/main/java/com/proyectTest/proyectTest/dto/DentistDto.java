package com.proyectTest.proyectTest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistDto {

    private int id;

    private String lastname;

    private String name;

    public DentistDto() {
    }
}
