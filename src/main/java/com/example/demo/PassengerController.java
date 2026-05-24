package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PassengerController {
    PassengerRepository passengerRepository;
    public PassengerController(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }
    @PostMapping ("/passengers")
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerRepository.save(passenger);
    }
    @GetMapping ("/passengers")
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }
    @GetMapping ("/passengers/{id}")
    public Optional<Passenger> getPassengerById(@PathVariable Long id) {
        return passengerRepository.findById(id);
    }
    @DeleteMapping ("/passengers/{id}")
    public void deletePassenger(@RequestBody Passenger passenger) {
        passengerRepository.delete(passenger);
    }
    @PutMapping ("/passengers/{id}")
    public void putPassenger(@RequestBody Passenger passenger) {
        passengerRepository.saveAndFlush(passenger);
    }
}
