package com.proyectTest.proyectTest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectTest.proyectTest.dto.AppointmentDto;
import com.proyectTest.proyectTest.entity.Appointment;
import com.proyectTest.proyectTest.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository)
    {
        this.appointmentRepository = appointmentRepository;
    }

    public List<AppointmentDto> getAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Appointment> appointments = appointmentRepository.findAll();
        List<AppointmentDto> appointmentsDto = new ArrayList<>();

        for (Appointment appointment : appointments){
            AppointmentDto appointmentDto = objectMapper.convertValue(appointment, AppointmentDto.class);
            appointmentsDto.add(appointmentDto);
        }

        return appointmentsDto;
    }

    public AppointmentDto create(Appointment appointment) {
        ObjectMapper objectMapper = new ObjectMapper();
        AppointmentDto appointmentDto;

        Appointment appointmentDB = appointmentRepository.save(appointment);

        appointmentDto = objectMapper.convertValue(appointmentDB, AppointmentDto.class);

        return appointmentDto;
    }

    public List<AppointmentDto> getAllByDentistId(int id){
        ObjectMapper objectMapper = new ObjectMapper();
        List<Appointment> appointments = appointmentRepository.getAllByDentistId(id);
        List<AppointmentDto> appointmentsDto = new ArrayList<>();

        for (Appointment appointment : appointments){
            AppointmentDto appointmentDto = objectMapper.convertValue(appointment, AppointmentDto.class);
            appointmentsDto.add(appointmentDto);
        }

        return appointmentsDto;
    }

    public List<AppointmentDto> getAllByDentistIdAndDate(int id, String date){
        ObjectMapper objectMapper = new ObjectMapper();
        List<Appointment> appointments = appointmentRepository.getAllByDentistIdAndDate(id, date);
        List<AppointmentDto> appointmentsDto = new ArrayList<>();

        for (Appointment appointment : appointments){
            AppointmentDto appointmentDto = objectMapper.convertValue(appointment, AppointmentDto.class);
            appointmentsDto.add(appointmentDto);
        }

        return appointmentsDto;
    }

    public List<AppointmentDto> getAllByPatientId(int id){
        ObjectMapper objectMapper = new ObjectMapper();
        List<Appointment> appointments = appointmentRepository.getAllByPatientId(id);
        List<AppointmentDto> appointmentsDto = new ArrayList<>();

        for (Appointment appointment : appointments){
            AppointmentDto appointmentDto = objectMapper.convertValue(appointment, AppointmentDto.class);
            appointmentsDto.add(appointmentDto);
        }

        return appointmentsDto;
    }

    public Optional<AppointmentDto> getById(int id){
        ObjectMapper objectMapper = new ObjectMapper();
        AppointmentDto appointmentDto;

        Optional<Appointment> appointment = appointmentRepository.findById(id);
        appointmentDto = objectMapper.convertValue(appointment.get(), AppointmentDto.class);

        return Optional.of(appointmentDto);
    }

    public AppointmentDto update(Appointment appointment){
        ObjectMapper objectMapper = new ObjectMapper();
        AppointmentDto appointmentDto;

        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointment.getId());
        Appointment appointmentDB = optionalAppointment.get();
        appointmentDB.setDate(appointment.getDate());

        appointmentRepository.save(appointmentDB);

        appointmentDto = objectMapper.convertValue(appointmentDB, AppointmentDto.class);

        return appointmentDto;
    }

    public void delete(int id) {
        appointmentRepository.deleteById(id);
    }
}
