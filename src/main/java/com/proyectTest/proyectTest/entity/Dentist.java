package com.proyectTest.proyectTest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="dentist")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String lastname;
    private String name;
    private int medical_registration;

    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<>();

    public Dentist() {
    }

}
