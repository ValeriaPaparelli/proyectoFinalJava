package com.proyectTest.proyectTest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name="dentist")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="lastname")
    private String lastname;
    @Column(name="name")
    private String name;
    @Column(name="medical_registration")
    private int medical_registration;

    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    private Set<Appointment> appointments = new HashSet<>();

    public Dentist() {
    }

    public Dentist(int id, String lastname, String name, int medical_registration) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.medical_registration = medical_registration;
    }
}
