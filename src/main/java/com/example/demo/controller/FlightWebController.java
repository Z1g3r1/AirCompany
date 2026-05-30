package com.example.demo.controller;

import com.example.demo.service.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlightWebController {
    FlightService flightService;

    public FlightWebController(FlightService flightService) {
        this.flightService = flightService;
    }
    @GetMapping ("/flights/page")
    public String listFlights(Model model) {
        model.addAttribute("flights", flightService.getAllFlights());
        return "flights";
    }
}
