package com.example.demo;

import jakarta.persistence.*;

@Entity @Table (name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn (name = "flight_id")
    private Flight flight;
    private boolean has_ticket;
    private byte age;
    private char gender;
    public Passenger() {}
    public Passenger(Long id, Flight flight, boolean has_ticket, byte age, char gender) {
        this.id = id;
        this.flight = flight;
        this.has_ticket = has_ticket;
        this.age = age;
        this.gender = gender;
    }

    public Passenger(Flight flight, boolean has_ticket, byte age, char gender) {
        this.flight = flight;
        this.has_ticket = has_ticket;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public Flight getFlight() {
        return flight;
    }

    public boolean isHas_ticket() {
        return has_ticket;
    }

    public byte getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }
}
