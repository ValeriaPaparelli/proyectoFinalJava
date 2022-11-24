package com.proyectTest.proyectTest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectTest.proyectTest.entity.Patient;
import com.proyectTest.proyectTest.dto.PatientDto;
import com.proyectTest.proyectTest.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository)
    {
        this.patientRepository = patientRepository;
    }

    public List<PatientDto> getAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> patientsDto = new ArrayList<>();

        for (Patient patient : patients){
            PatientDto patientDto = objectMapper.convertValue(patient, PatientDto.class);
            patientsDto.add(patientDto);
        }
        
        return patientsDto;
    }

    public PatientDto create(Patient patient) {
        ObjectMapper objectMapper = new ObjectMapper();
        PatientDto patientDto;

        Patient patientDB = patientRepository.save(patient);
        patientDto = objectMapper.convertValue(patientDB, PatientDto.class);
        
        return patientDto;
    }

    public Optional<PatientDto> getById(int id){
        ObjectMapper objectMapper = new ObjectMapper();
        PatientDto patientDto;

        Optional<Patient> patient = patientRepository.findById(id);
        patientDto = objectMapper.convertValue(patient.get(), PatientDto.class);

        return Optional.of(patientDto);
    }

    public PatientDto update(Patient patient){
        ObjectMapper objectMapper = new ObjectMapper();
        PatientDto patientDto;

        Optional<Patient> optionalPatient = patientRepository.findById(patient.getId());
        Patient patientDB = optionalPatient.get();
        patientDB.setName(patient.getName());
        patientDB.setLastname(patient.getLastname());
        patientDB.setAddress(patient.getAddress());
        patientDB.setDni(patient.getDni());
        patientDB.setRegistration_date(patient.getRegistration_date());

        patientRepository.save(patientDB);

        patientDto = objectMapper.convertValue(patientDB, PatientDto.class);

        return patientDto;
    }

    public void delete(int id) {
        patientRepository.deleteById(id);
    }

}

