package com.GestionAuto.Trip.repository;

import com.GestionAuto.Trip.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {

}
