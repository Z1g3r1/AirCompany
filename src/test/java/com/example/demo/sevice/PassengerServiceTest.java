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


        Passenger result = passengerRepository.save(passenger);

        assertEquals(passenger, result);
        Mockito.verify(passengerRepository, Mockito.times(1)).save(passenger);
    }
}
