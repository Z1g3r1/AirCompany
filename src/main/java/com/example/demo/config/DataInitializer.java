package com.example.demo.config;

import com.example.demo.classes.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    AppUserRepository appUserRepository;
    PasswordEncoder passwordEncoder;
    public DataInitializer(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void run(String... args) throws Exception {
        if(appUserRepository.findByUsername("admin").isEmpty()) {
           appUserRepository.save(new AppUser("admin", passwordEncoder.encode("admin123"), "ROLE_ADMIN"));
        }
    }
}
