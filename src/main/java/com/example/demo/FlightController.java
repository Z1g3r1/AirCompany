package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FlightController {
    @GetMapping("/flights")
    public List<Flight> getAllFlights(Flight flight) {
        flight.addFlight(1L, "Monster-11", "Aviasales");
        flight.addFlight(2L, "ISU-1343", "AirShip-Bus");
        return flight.getFlights();
    }
}
class Flight {
    Long id;
    String flightNumber;
    String companyName;
    public List<Flight> flights = new ArrayList<>();

    public Flight(Long id, String flightNumber, String companyName, List<Flight> flights) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.companyName = companyName;
        this.flights = flights;
    }

    public Flight(Long id, String flightNumber, String companyName) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.companyName = companyName;
    }

    public Flight() {}

    public void addFlight(Long id, String flightNumber, String companyName) {
        flights.add(new Flight(id, flightNumber, companyName));
    }
    public List<Flight> getFlights() {
        return flights;
    }

    public Long getId() {
        return id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getCompanyName() {
        return companyName;
    }
}