package com.example.demo.controller;

import com.example.demo.classes.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    AppUserRepository appUserRepository;
    PasswordEncoder passwordEncoder;
    public RegistrationController (AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping("/register")
    public String registration(@RequestParam String username, @RequestParam String password) {
        AppUser user = new AppUser(username, passwordEncoder.encode(password), "ROLE_PASSENGER");
        if (appUserRepository.findByUsername(user.getUsername()).isEmpty()) {
            appUserRepository.save(user);
            return "redirect:/login?registered=true";
        }
        return "redirect:/register?error=userexists";
    }
}
