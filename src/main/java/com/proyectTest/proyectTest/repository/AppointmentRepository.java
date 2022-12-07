package com.proyectTest.proyectTest.repository;

import com.proyectTest.proyectTest.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Query("FROM Appointment a WHERE a.dentist.id = ?1")
    public List<Appointment> getAllByDentistId(int id);

    @Query("FROM Appointment a WHERE a.dentist.id = ?1 AND a.date = ?2")
    public List<Appointment> getAllByDentistIdAndDate(int id, String date);

    @Query("FROM Appointment a WHERE a.patient.id = ?1")
    public List<Appointment> getAllByPatientId(int id);
}
