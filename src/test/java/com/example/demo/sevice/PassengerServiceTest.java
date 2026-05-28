package com.example.demo.sevice;

import com.example.demo.Passenger;
import com.example.demo.PassengerRepository;
import com.example.demo.service.PassengerService;
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
public class PassengerServiceTest {
    @Mock
    PassengerRepository passengerRepository;
    @InjectMocks
    PassengerService passengerService;
    @Test
    public void testCreatePassenger() {
        Passenger passenger = new Passenger();
        Mockito.when(passengerRepository.save(passenger)).thenReturn(passenger);


        Passenger result = passengerService.createPassenger(passenger);

        assertEquals(passenger, result);
        Mockito.verify(passengerRepository, Mockito.times(1)).save(passenger);
    }
    @Test
    public void testGetPassengerById() {
        Passenger passenger = new Passenger();
        Long id = passenger.getId();
        Mockito.when(passengerRepository.findById(id)).thenReturn(Optional.of(passenger));

        Optional<Passenger> result = passengerService.getPassengerById(id);

        assertEquals(Optional.of(passenger), result);
        Mockito.verify(passengerRepository, Mockito.times(1)).findById(id);
    }
    @Test
    public void testPutPassenger() {
        Passenger passenger = new Passenger();
        passengerService.putPassenger(passenger);
        Mockito.verify(passengerRepository, Mockito.times(1)).saveAndFlush(passenger);
    }
    @Test
    public void testDeletePassenger() {
        Passenger passenger = new Passenger();
        passengerService.deletePassenger(passenger.getId());
        Mockito.verify(passengerRepository, Mockito.times(1)).deleteById(passenger.getId());
    }
    @Test
    public void testGetAllPassengers() {
        List<Passenger> list = new ArrayList<>();
        Mockito.when(passengerRepository.findAll()).thenReturn(list);

        List<Passenger> result = passengerService.getAllPassengers();

        assertEquals(list, result);
        Mockito.verify(passengerRepository, Mockito.times(1)).findAll();
    }
}
