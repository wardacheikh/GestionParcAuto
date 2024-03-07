package com.GestionAuto.Trip.Services;

import com.GestionAuto.Trip.Exceptions.TripExceptions;
import com.GestionAuto.Trip.models.Trip;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface TripService {
    public void AddTrip(Trip trip ) throws TripExceptions;
    public List<Trip>getAllTrip();
    public void deleteTrip(Long id) throws TripExceptions;
    public  void updateTrip(Long id ,String depanature , String destination , LocalDate departureDate, LocalTime departureTime ,
    LocalDate arrivalDate , LocalTime arrivalTime , int numberofpassangers) throws TripExceptions;
}
