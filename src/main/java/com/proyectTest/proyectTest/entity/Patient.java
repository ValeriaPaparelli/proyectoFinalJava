package com.proyectTest.proyectTest.entity;

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
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="lastname")
    private String lastname;
    @Column(name="name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name="dni")
    private int dni;
    @Column(name="registration_date")
    private String registration_date;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Appointment> appointments = new HashSet<>();

    public Patient() {
    }
}
