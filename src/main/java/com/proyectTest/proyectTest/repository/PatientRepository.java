package com.proyectTest.proyectTest.repository;

import com.proyectTest.proyectTest.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
