package com.example.demo;

import com.example.demo.service.PassengerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PassengerController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return errors;
    }
    PassengerService passengerService;
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }
    @PostMapping ("/passengers")
    public Passenger createPassenger(@Valid @RequestBody Passenger passenger) {
        return passengerService.createPassenger(passenger);
    }
    @GetMapping ("/passengers")
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }
    @GetMapping ("/passengers/{id}")
    public Optional<Passenger> getPassengerById(@PathVariable Long id) {
        return passengerService.getPassengerById(id);
    }
    @DeleteMapping ("/passengers/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
    }
    @PutMapping ("/passengers/{id}")
    public void putPassenger(@RequestBody Passenger passenger) {
        passengerService.putPassenger(passenger);
    }
}
