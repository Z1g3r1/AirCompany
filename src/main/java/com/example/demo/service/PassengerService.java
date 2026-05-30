package com.example.demo.service;

import com.example.demo.classes.Passenger;
import com.example.demo.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    PassengerRepository passengerRepository;
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }
    public Optional<Passenger> getPassengerById(Long id) {
        return passengerRepository.findById(id);
    }
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
    public void putPassenger(Passenger passenger) {
        passengerRepository.saveAndFlush(passenger);
    }
}
