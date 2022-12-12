package com.proyectTest.proyectTest.controller;

import com.proyectTest.proyectTest.dto.DentistDto;
import com.proyectTest.proyectTest.entity.Dentist;
import com.proyectTest.proyectTest.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping()
    public ResponseEntity<List<DentistDto>> getAll() {
        return ResponseEntity.ok(dentistService.getAll());
    }

    @PostMapping()
    public ResponseEntity<DentistDto> create(@RequestBody Dentist dentist) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dentistService.create(dentist));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistDto> getById(@PathVariable Long id) {
        DentistDto dentistDto = dentistService.getById(id).orElse(null);
        return ResponseEntity.ok(dentistDto);
    }

    @PutMapping()
    public ResponseEntity<DentistDto> update(@RequestBody Dentist dentist) {
        if(dentist.getId() != null && dentistService.getById(dentist.getId()) != null) {
            return ResponseEntity.ok(dentistService.update(dentist));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if(dentistService.getById(id) != null) {
            dentistService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Dentista Eliminado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
