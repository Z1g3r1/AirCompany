package com.example.demo;

import com.example.demo.service.FlightService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class FlightController {
    FlightService flightService;
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }
    @PostMapping("/flights")
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.createFlight(flight);
    }
    @DeleteMapping("/flights/{id}")
    public void deleteFlight (@PathVariable Long id) {
        flightService.deleteFlight(id);
    }
    @PutMapping ("/flights/{id}")
    public void putFlight(@RequestBody Flight flight) {
        flightService.putFlight(flight);
    }
    @GetMapping ("/flights/{id}")
    public Optional<Flight> getById(@PathVariable Long id) {
        return flightService.getById(id);
    }
    @GetMapping ("/flights")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

}
