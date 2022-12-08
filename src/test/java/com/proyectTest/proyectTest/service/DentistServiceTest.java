package com.proyectTest.proyectTest.service;

import com.proyectTest.proyectTest.dto.DentistDto;
import com.proyectTest.proyectTest.entity.Dentist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DentistServiceTest {
    @Autowired
    private DentistService dentistService;

    @Test
    public void createDentistTest(){
        Dentist dentist = new Dentist();
        dentist.setLastname("Dominguez");
        dentist.setName("Omar");
        dentist.setMedical_registration(124563);

        dentistService.create(dentist);

        Optional<DentistDto> dentistDB = dentistService.getById(1);

        assertTrue(dentistDB.isPresent());
    }

    @Test
    public void updateDentistTest(){
        Dentist dentistUpdate = new Dentist();
        dentistUpdate.setId(1);
        dentistUpdate.setLastname("Domingues");
        dentistUpdate.setName("Oscar");
        dentistUpdate.setMedical_registration(124563);

        dentistService.update(dentistUpdate);

        Optional<DentistDto> dentistDB = dentistService.getById(1);

        assertTrue(dentistDB.get().getLastname().equals("Domingues"));
        assertTrue(dentistDB.get().getName().equals("Oscar"));
    }
}
