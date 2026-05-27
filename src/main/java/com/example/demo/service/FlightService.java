package com.example.demo.service;

import com.example.demo.Flight;
import com.example.demo.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
    public void putFlight(Flight flight) {
        flightRepository.saveAndFlush(flight);
    }
    public Optional<Flight> getById(Long id) {
        return flightRepository.findById(id);
    }
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}
