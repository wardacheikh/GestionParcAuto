package com.GestionAuto.Trip.repository;

import com.GestionAuto.Trip.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    @Query("SELECT d FROM Driver d WHERE d.id NOT IN " +
            "(SELECT t.driver.id FROM Trip t WHERE t.arrivalDate" +
            " BETWEEN :departureDate AND :arrivalDate)")
    List<Driver> findAvailableDrivers (@Param("departureDate") LocalDate departureDate,
             @Paramj("arrivalDate") LocalDate arrivalDate);



    @Query("SELECT d FROM Driver d WHERE d.id IN " +
            "(SELECT t.driver.id FROM Trip t WHERE t.driver.id = d.id)")
    List<Driver> findDriversWithTrips();

}
