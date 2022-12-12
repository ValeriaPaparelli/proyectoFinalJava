package com.proyectTest.proyectTest.service;

import com.proyectTest.proyectTest.dto.PatientDto;
import com.proyectTest.proyectTest.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void createPatientTest(){
        Patient patient = new Patient();
        patient.setLastname("Rodriguez");
        patient.setName("Mateo");
        patient.setAddress("Aranguren 367");
        patient.setRegistration_date("2020-02-12");
        patient.setDni(32456178);

        patientService.create(patient);

        Optional<PatientDto> patientDB = patientService.getById(1L);

        assertTrue(patientDB.isPresent());
    }

    @Test
    public void updatePatientTest(){
        Patient patient = new Patient();
        patient.setLastname("Rodriguez");
        patient.setName("Mateo");
        patient.setAddress("Aranguren 367");
        patient.setRegistration_date("2020-02-12");
        patient.setDni(32456178);

        patientService.create(patient);

        Patient patientUpdate = new Patient();
        patientUpdate.setId(1L);
        patientUpdate.setLastname("Lopez");
        patientUpdate.setName("José");
        patientUpdate.setAddress("Pichincha 456");
        patientUpdate.setRegistration_date("2021-05-07");
        patientUpdate.setDni(26789120);

        patientService.update(patientUpdate);

        Optional<PatientDto> patientDB = patientService.getById(1L);

        assertTrue(patientDB.get().getLastname().equals("Lopez"));
        assertTrue(patientDB.get().getName().equals("José"));
        assertFalse(patientDB.get().getAddress().equals("Pichincha 490"));
    }
}
