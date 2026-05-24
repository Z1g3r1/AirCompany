package com.example.demo;

import jakarta.persistence.*;

@Entity @Table (name = "flights")
public class Flight {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long flight_id;
    private String flightNumber;
    private String companyName;


    public Flight(Long id, String flightNumber, String companyName) {
        this.flight_id = id;
        this.flightNumber = flightNumber;
        this.companyName = companyName;
    }

    public Flight() {
    }

    public Long getFlight_id() {
        return flight_id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getCompanyName() {
        return companyName;
    }
}
