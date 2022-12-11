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
        dentist.setLastname("Dominguez");
        dentist.setName("Omar");
        dentist.setMedical_registration(124563);

        dentistService.create(dentist);

        Patient patient = new Patient();
        patient.setLastname("Rodriguez");
        patient.setName("Mateo");
        patient.setAddress("Aranguren 367");
        patient.setRegistration_date("2020-02-12");
        patient.setDni(32456178);

        patientService.create(patient);

        Appointment appointment = new Appointment();
        appointment.setDate("2022-10-04");

        dentist.setId(1);
        appointment.setDentist(dentist);

        patient.setId(1);
        appointment.setPatient(patient);

        appointmentService.create(appointment);

        Optional<AppointmentDto> appointmentDB = appointmentService.getById(1);

        assertTrue(appointmentDB.isPresent());
        assertEquals(appointment.getDate(), "2022-10-04");
    }

}
