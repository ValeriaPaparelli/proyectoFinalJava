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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;

    @ManyToOne()
    @JoinColumn(name="patient_id", nullable = false)
    private Patient patient;

    @ManyToOne()
    @JoinColumn(name="dentist_id", nullable = false)
    private Dentist dentist;

    public Appointment() {
    }
}
