package com.GestionAuto.Trip.Services;
import com.GestionAuto.Trip.Exceptions.TripExceptions;
import com.GestionAuto.Trip.models.Trip;
import com.GestionAuto.Trip.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService{

@Autowired
    private TripRepository tripRepository ;
    @Override
    public Trip AddTrip(Trip trip) throws TripExceptions {
        Optional<Trip> tripOptional = tripRepository.findById(trip.getId());
        if (tripOptional.isPresent())
        {
            throw new TripExceptions("Trip existe déjà");
        }
        else{
          if( trip.getDepartureDate().isBefore(trip.getArrivalDate()))
              return tripRepository.save(trip);
          if(trip.getDepartureDate().isEqual(trip.getArrivalDate())
                  &&(trip.getDepartureTime().isBefore(trip.getArrivalTime()))) {
              return tripRepository.save(trip);
          }
          else {
              throw new TripExceptions("La date de départ doit être avant la date d'arrivée");
          }
        }
    }

    @Override
    public List<Trip> getAllTrip() {
       return tripRepository.findAll();
    }

    @Override
     public void deleteTrip(Long id) throws TripExceptions {
     boolean exists= tripRepository.existsById(id);
     if(exists){
         tripRepository.deleteById(id);
     }
        throw new TripExceptions("La date de départ doit être avant la date d'arrivée");

    }

    @Override
    public void updateTrip(Long id ,String depanature , String destination , LocalDate departureDate, LocalTime departureTime,
    LocalDate arrivalDate , LocalTime arrivalTime , int numberofpassangers) throws TripExceptions {


        Trip trip = tripRepository.findById(id).orElseThrow(() -> new IllegalStateException("id n'existe pas "));

        if (depanature != null && !depanature.isEmpty() && !Objects.equals(trip.getDepanature(), depanature)) {
            trip.setDepanature(depanature);
        }
        if (destination != null && !destination.isEmpty() && !Objects.equals(trip.getDestination(), destination)) {
            trip.setDestination(destination);
        }

        if (numberofpassangers !=0  && !Objects.equals(trip.getNumberOfPassangers(), numberofpassangers)) {
            trip.setNumberOfPassangers(numberofpassangers);
        }

        if (departureDate.isBefore(arrivalDate)|| departureTime.isBefore(arrivalTime)) {

            if (departureDate != null && !Objects.equals(trip.getDepartureDate(), departureDate)) {
                trip.setDepartureDate(departureDate);
            }
            if (departureTime != null && !Objects.equals(trip.getDepartureTime(), departureTime)) {
                trip.setDepartureTime(departureTime);
            }
            if (arrivalDate != null && !Objects.equals(trip.getArrivalDate(), arrivalDate)) {
                trip.setArrivalDate(arrivalDate);
            }
            if (arrivalTime != null && !Objects.equals(trip.getDepartureDate(), arrivalTime)) {
                trip.setArrivalTime(arrivalTime);
            }
        }

        else {
            throw new TripExceptions("La date de départ doit être avant la date d'arrivée");
        }
    }
    }

