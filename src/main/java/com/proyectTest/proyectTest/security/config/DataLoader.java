package com.proyectTest.proyectTest.security.config;

import com.proyectTest.proyectTest.entity.AppUser;
import com.proyectTest.proyectTest.entity.AppUserRole;
import com.proyectTest.proyectTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        userRepository.save(new AppUser("User", "UserName", "test@test.com",
                hashedPassword, AppUserRole.USER));
    }
}
