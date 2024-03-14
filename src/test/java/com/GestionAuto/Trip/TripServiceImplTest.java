package com.GestionAuto.Trip;
import com.GestionAuto.Trip.Exceptions.TripExceptions;
import com.GestionAuto.Trip.Services.TripService;
import com.GestionAuto.Trip.models.Trip;
import com.GestionAuto.Trip.models.VehiculeType;
import com.GestionAuto.Trip.repository.TripRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TripServiceImplTest {
    @Autowired
    private TripService tripService;

    @Test
    @DisplayName("Test d'ajout de voyage avec succès")
    public void testAddTrip() throws TripExceptions {
        Trip tripsucess = new Trip();
        tripsucess.setId(1L);
        tripsucess.setDepanature("paris");
        tripsucess.setDestination("madrid");
        tripsucess.setNumberOfPassangers(4);
        tripsucess.setDepartureDate(LocalDate.of(2024, 3, 12));
        tripsucess.setArrivalDate(LocalDate.of(2024, 3, 13));
        tripsucess.setDepartureTime(LocalTime.of(11, 0));
        tripsucess.setArrivalTime(LocalTime.of(13, 0));
        tripsucess.setVehiculeType(VehiculeType.BUS);
        Trip addedTrip = tripService.AddTrip(tripsucess);
        assertNotNull(addedTrip);
    }
    @Test
    @DisplayName("Test d'ajout de voyage avec date de départ invalide")
   public void testAddTripInvalidDepartureDate() {
        Trip trip = new Trip();
        trip.setId(1L);
        trip.setDepanature("paris");
        trip.setDestination("madrid");
        trip.setNumberOfPassangers(4);
        trip.setDepartureDate(LocalDate.of(2024, 3, 11)); // Setting departure date after arrival date
        trip.setArrivalDate(LocalDate.of(2024, 3, 10)); // Setting arrival date before departure date
        trip.setDepartureTime(LocalTime.of(10, 0));
        trip.setArrivalTime(LocalTime.of(12, 0));
        trip.setVehiculeType(VehiculeType.BUS);
        Assertions.assertThrows(TripExceptions.class, () -> tripService.AddTrip(trip));
 }

 }
