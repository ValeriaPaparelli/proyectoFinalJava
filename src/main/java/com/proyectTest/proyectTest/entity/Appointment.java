package com.proyectTest.proyectTest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name= "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id")
    private Patient patient;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dentist_id")
    private Dentist dentist;

    public Appointment() {
    }
}
