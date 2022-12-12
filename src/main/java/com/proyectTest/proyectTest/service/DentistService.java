package com.proyectTest.proyectTest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectTest.proyectTest.dto.DentistDto;
import com.proyectTest.proyectTest.entity.Dentist;;
import com.proyectTest.proyectTest.repository.DentistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistService {
       private final DentistRepository dentistRepository;

        public DentistService(DentistRepository dentistRepository)
        {
            this.dentistRepository = dentistRepository;
        }

        public List<DentistDto> getAll() {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Dentist> dentists = dentistRepository.findAll();
            List<DentistDto> dentistsDto = new ArrayList<>();

            for (Dentist dentist : dentists){
                DentistDto dentistDto = objectMapper.convertValue(dentist, DentistDto.class);
                dentistsDto.add(dentistDto);
            }

            return dentistsDto;
        }

        public DentistDto create(Dentist dentist) {
            ObjectMapper objectMapper = new ObjectMapper();
            DentistDto dentistDto;

            Dentist dentistDB = dentistRepository.save(dentist);
            dentistDto = objectMapper.convertValue(dentistDB, DentistDto.class);

            return dentistDto;
        }

        public Optional<DentistDto> getById(Long id) {
            ObjectMapper objectMapper = new ObjectMapper();
            DentistDto dentistDto;

            Optional<Dentist> dentist = dentistRepository.findById(id);
            dentistDto = objectMapper.convertValue(dentist.get(), DentistDto.class);

            return Optional.of(dentistDto);
        }

        public DentistDto update(Dentist dentist){
            ObjectMapper objectMapper = new ObjectMapper();
            DentistDto dentistDto;

            Optional<Dentist> optionalDentist = dentistRepository.findById(dentist.getId());
            Dentist dentistDB = optionalDentist.get();
            dentistDB.setName(dentist.getName());
            dentistDB.setLastname(dentist.getLastname());
            dentistDB.setMedical_registration(dentist.getMedical_registration());

            dentistRepository.save(dentistDB);

            dentistDto = objectMapper.convertValue(dentistDB, DentistDto.class);

            return dentistDto;
        }

        public void delete(Long id) {
            dentistRepository.deleteById(id);
        }

    }
