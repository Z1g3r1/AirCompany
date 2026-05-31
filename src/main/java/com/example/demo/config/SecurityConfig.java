package com.example.demo.config;

import com.example.demo.service.AppUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final AppUserService appUserService;
    public SecurityConfig(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http
                .userDetailsService(appUserService)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register/**").permitAll()
                        .requestMatchers("/flights/**").permitAll()
                        .requestMatchers("/passengers/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/flights/page", true).loginProcessingUrl("/login").permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/login?logout=true").permitAll());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
