package com.example.demo.controller;

import com.example.demo.classes.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    AppUserRepository appUserRepository;
    PasswordEncoder passwordEncoder;
    public RegistrationController (AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping ("/register")
    public void registration(@RequestBody AppUser user) {
        if (appUserRepository.findByUsername(user.getUsername()).isEmpty()) {
            appUserRepository.save(new AppUser(user.getUsername(), passwordEncoder.encode(user.getPassword()), "ROLE_PASSENGER"));
        }
    }
}
