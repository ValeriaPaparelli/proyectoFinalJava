package com.proyectTest.proyectTest.controller;

import com.proyectTest.proyectTest.dto.AppointmentDto;
import com.proyectTest.proyectTest.entity.Appointment;
import com.proyectTest.proyectTest.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @GetMapping()
    public ResponseEntity<List<AppointmentDto>> getAll() {
        return ResponseEntity.ok(appointmentService.getAll());
    }

    @PostMapping()
    public ResponseEntity<AppointmentDto> create(@RequestBody Appointment appointment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.create(appointment));
    }

    @GetMapping("/dentist/{id}")
    public ResponseEntity<List<AppointmentDto>> getAllByDentistId(@PathVariable Integer id){
        return ResponseEntity.ok(appointmentService.getAllByDentistId(id));
    }

    @GetMapping("/dentist/{id}/date/{date}")
    public ResponseEntity<List<AppointmentDto>> getAllByDentistIdAndDate(@PathVariable int id, @PathVariable String date){
        return ResponseEntity.ok(appointmentService.getAllByDentistIdAndDate(id, date));
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<AppointmentDto>> getAllByPatientId(@PathVariable Integer id){
        return ResponseEntity.ok(appointmentService.getAllByPatientId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getById(@PathVariable Integer id){
        AppointmentDto appointmentDto = appointmentService.getById(id).orElse(null);
        return ResponseEntity.ok(appointmentDto);
    }



    @PutMapping()
    public ResponseEntity<AppointmentDto> update(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.update(appointment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        appointmentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Patient deleted");
    }

}
