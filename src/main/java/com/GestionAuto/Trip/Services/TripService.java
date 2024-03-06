package com.GestionAuto.Trip.Services;

import com.GestionAuto.Trip.models.Trip;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface TripService {
    public void AddTrip(Trip trip );
    public List<Trip>getAllTrip();
    public void deleteTrip(Long id);
    public  void updateTrip(Long id ,String depanature , String destination , LocalDate departureDate, LocalTime departureTime ,
    LocalDate arrivalDate , LocalTime arrivalTime , int numberofpassangers);
}
