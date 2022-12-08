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

        Optional<PatientDto> patientDB = patientService.getById(3);

        assertTrue(patientDB.isPresent());
    }

    @Test
    public void updatePatientTest(){
        Patient patientUpdate = new Patient();
        patientUpdate.setId(3);
        patientUpdate.setLastname("Ramirez");
        patientUpdate.setName("Matias");
        patientUpdate.setAddress("San Martin 3489");
        patientUpdate.setRegistration_date("2020-02-12");
        patientUpdate.setDni(32456178);

        patientService.update(patientUpdate);

        Optional<PatientDto> patientDB = patientService.getById(3);

        assertTrue(patientDB.get().getLastname().equals("Ramirez"));
        assertTrue(patientDB.get().getName().equals("Matias"));
        assertFalse(patientDB.get().getAddress().equals("Aranguren 367"));
    }
}
