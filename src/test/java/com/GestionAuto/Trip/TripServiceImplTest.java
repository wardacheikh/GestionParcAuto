package com.GestionAuto.Trip;
import com.GestionAuto.Trip.Exceptions.TripExceptions;
import com.GestionAuto.Trip.Services.TripServiceImpl;
import com.GestionAuto.Trip.models.Trip;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TripServiceIntegrationTest {

    @Autowired
    private TripServiceImpl tripService;

    @Test
    public void testAddTrip() throws TripExceptions {
        Trip trip = new Trip(/* initialize Trip */);
        trip.setDepartureDate(LocalDate.of(2024, 3, 10));
        trip.setArrivalDate(LocalDate.of(2024, 3, 11));
        trip.setDepartureTime(LocalTime.of(10, 0));
        trip.setArrivalTime(LocalTime.of(12, 0));

        tripService.AddTrip(trip);

    }

    @Test
    public void testAddTripInvalidDate() {
        Trip trip = new Trip(/* initialize Trip */);
        trip.setDepartureDate(LocalDate.of(2024, 3, 11));
        trip.setArrivalDate(LocalDate.of(2024, 3, 10));
        trip.setDepartureTime(LocalTime.of(10, 0));
        trip.setArrivalTime(LocalTime.of(12, 0));

        assertThrows(TripExceptions.class, () -> tripService.AddTrip(trip));
    }
}

