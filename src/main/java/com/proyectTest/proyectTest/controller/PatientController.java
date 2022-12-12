package com.proyectTest.proyectTest.controller;

import com.proyectTest.proyectTest.entity.Patient;
import com.proyectTest.proyectTest.service.PatientService;
import com.proyectTest.proyectTest.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping()
    public ResponseEntity<List<PatientDto>> getAll() {
        return ResponseEntity.ok(patientService.getAll());
    }

    @PostMapping()
    public ResponseEntity<PatientDto> create(@RequestBody Patient patient) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.create(patient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getById(@PathVariable Long id)  {
        PatientDto patientDto = patientService.getById(id).orElse(null);
        return ResponseEntity.ok(patientDto);
    }

    @PutMapping()
    public ResponseEntity<PatientDto> update(@RequestBody Patient patient) {
        if(patient.getId() != null && patientService.getById(patient.getId()) != null) {
            return ResponseEntity.ok(patientService.update(patient));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if(patientService.getById(id) != null) {
            patientService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Paciente Eliminado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
