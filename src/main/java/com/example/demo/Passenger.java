package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity @Table (name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn (name = "flight_id")
    private Flight flight;
    private boolean has_ticket;
    @Min(0) @Max(150)
    private byte age;
    @Pattern(regexp = "[MF]")
    private String gender;
    public Passenger() {}
    public Passenger(Long id, Flight flight, boolean has_ticket, byte age, String gender) {
        this.id = id;
        this.flight = flight;
        this.has_ticket = has_ticket;
        this.age = age;
        this.gender = gender;
    }

    public Passenger(Flight flight, boolean has_ticket, byte age, String gender) {
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

    public String getGender() {
        return gender;
    }
}
