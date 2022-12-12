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

    @Autowired
    private DentistService dentistService;

    @Autowired
    private PatientService patientService;

    @Test
    public void createAppointmentTest(){
        Dentist dentist = new Dentist();
        dentist.setId(1L);

        Patient patient = new Patient();
        patient.setId(1L);

        Appointment appointment = new Appointment();
        appointment.setDate("2022-10-04");

        appointment.setDentist(dentist);
        appointment.setPatient(patient);

        appointmentService.create(appointment);

        Optional<AppointmentDto> appointmentDB = appointmentService.getById(2L);

        assertTrue(appointmentDB.isPresent());
        assertEquals(appointment.getDate(), "2022-10-04");
        assertEquals(appointment.getDentist().getId(), 1L);
        assertEquals(appointment.getPatient().getId(), 1L);
    }

}
