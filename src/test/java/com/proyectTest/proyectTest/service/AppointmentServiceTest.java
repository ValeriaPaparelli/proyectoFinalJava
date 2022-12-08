package com.proyectTest.proyectTest.service;

import com.proyectTest.proyectTest.dto.AppointmentDto;
import com.proyectTest.proyectTest.entity.Appointment;
import com.proyectTest.proyectTest.entity.Dentist;
import com.proyectTest.proyectTest.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AppointmentServiceTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void createAppointmentTest(){
        Dentist dentist = new Dentist();
        dentist.setId(1);

        Patient patient = new Patient();
        patient.setId(3);

        Appointment appointment = new Appointment();
        appointment.setDate("2022-10-04");
        appointment.setDentist(dentist);
        appointment.setPatient(patient);

        appointmentService.create(appointment);

        Optional<AppointmentDto> appointmentDB = appointmentService.getById(6);

        assertTrue(appointmentDB.isPresent());
        assertEquals(appointment.getDate(), "2022-10-04");
        assertEquals(appointment.getDentist().getId(), 1);
        assertEquals(appointment.getPatient().getId(), 3);
    }

}
