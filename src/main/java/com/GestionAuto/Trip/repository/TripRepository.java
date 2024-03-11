package com.GestionAuto.Trip.repository;

import com.GestionAuto.Trip.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query("SELECT t FROM Trip t WHERE t.driver.id = :driverId")
    List<Trip> findTripsByDriverId(@Param("driverId") Long driverId);

}
