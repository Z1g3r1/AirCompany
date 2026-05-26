package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class FlightController {
    FlightRepository flightRepository;
    public FlightController(FlightRepository fR) {
        this.flightRepository = fR;
    }
    @PostMapping("/flights")
    public Flight createFlight(@RequestBody Flight flight) {
        return flightRepository.save(flight);
    }
    @DeleteMapping("/flights/{id}")
    public void deleteFlight (@PathVariable Long id) {
        flightRepository.deleteById(id);
    }
    @PutMapping ("/flights/{id}")
    public void putFlight(@RequestBody Flight flight) {
        flightRepository.saveAndFlush(flight);
    }
    @GetMapping ("/flights/{id}")
    public Optional<Flight> getById(@PathVariable Long id) {
        return flightRepository.findById(id);
    }
    @GetMapping ("/flights")
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

}
