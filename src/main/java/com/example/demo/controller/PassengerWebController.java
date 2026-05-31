package com.example.demo.controller;

import com.example.demo.service.PassengerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PassengerWebController {
    PassengerService passengerService;

    public PassengerWebController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/passengers/page")
    public String listPassengers(Model model) {
        model.addAttribute("passengers", passengerService.getAllPassengers());
        return "passengers";
    }
}
