package com.example.demo.sevice;

import com.example.demo.classes.Flight;
import com.example.demo.repository.FlightRepository;
import com.example.demo.service.FlightService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {
    @Mock
    FlightRepository flightRepository;
    @InjectMocks
    FlightService flightService;
    @Test
    public void testGetAllFlights() {
        List<Flight> list = new ArrayList<>();
        Mockito.when(flightRepository.findAll()).thenReturn(list);

        List<Flight> result = flightService.getAllFlights();
        assertEquals(list, result);
        Mockito.verify(flightRepository, Mockito.times(1)).findAll();
    }
    @Test
    public void testCreateFlight() {
        Flight flight = new Flight();
        Mockito.when(flightRepository.save(flight)).thenReturn(flight);

        Flight result = flightService.createFlight(flight);

        assertEquals(flight, result);
        Mockito.verify(flightRepository, Mockito.times(1)).save(flight);
    }
    @Test
    public void testPutFlight() {
        Flight flight = new Flight();
        flightService.putFlight(flight);
        Mockito.verify(flightRepository, Mockito.times(1)).saveAndFlush(flight);
    }
    @Test
    public void testDeleteFlight() {
        Flight flight = new Flight();
        flightService.deleteFlight(flight.getFlight_id());
        Mockito.verify(flightRepository, Mockito.times(1)).deleteById(flight.getFlight_id());
    }
    @Test
    public void testGetById() {
        Flight flight = new Flight();
        Mockito.when(flightRepository.findById(flight.getFlight_id())).thenReturn(Optional.of(flight));

        Optional<Flight> result = flightService.getById(flight.getFlight_id());

        assertEquals(Optional.of(flight), result);
        Mockito.verify(flightRepository, Mockito.times(1)).findById(flight.getFlight_id());
    }
}
