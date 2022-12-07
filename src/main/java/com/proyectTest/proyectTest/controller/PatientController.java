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
    public ResponseEntity<PatientDto> getById(@PathVariable Integer id){
        PatientDto patientDto = patientService.getById(id).orElse(null);
        return ResponseEntity.ok(patientDto);
    }

    @PutMapping()
    public ResponseEntity<PatientDto> update(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.update(patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        patientService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Patient deleted");
    }

}
