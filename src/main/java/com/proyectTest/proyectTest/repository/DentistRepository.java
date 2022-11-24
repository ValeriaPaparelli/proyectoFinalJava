package com.proyectTest.proyectTest.repository;

import com.proyectTest.proyectTest.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
