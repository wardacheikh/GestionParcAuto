package com.GestionAuto.Trip.Controllers;
import com.GestionAuto.Trip.Exceptions.TripExceptions;
import com.GestionAuto.Trip.Services.TripService;
import com.GestionAuto.Trip.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class TripController {
    @Autowired
    private TripService tripService ;

@GetMapping(path = "/listTrip")
    public List<Trip> getAllTrip(){
    return tripService.getAllTrip();
}

@PostMapping(path = "/addTrip")
public String addTrip(@RequestBody Trip trip  ) throws TripExceptions {
    tripService.AddTrip(trip);
    return "trip added with success";
}
@PutMapping(path = "{TripId}")
    public String updateTrip(@PathVariable("{TripId}") Long TripId ,
                           @RequestParam(required = false)String depanature ,
                           @RequestParam(required = false)String destination ,
                           LocalDate departureDate, LocalTime departureTime,
                           @RequestParam(required = false)  LocalDate arrivalDate ,
                           @RequestParam(required = false) LocalTime arrivalTime ,
                           @RequestParam(required = false) int numberofpassangers) throws TripExceptions {

            tripService.updateTrip(TripId,depanature,destination,departureDate,
            departureTime,arrivalDate,arrivalTime,numberofpassangers);
    return "Trip Updates succesfully";
                           }

 @DeleteMapping(path = "{TripId}")
 public String deleteTrip(@PathVariable("{TripId}") Long TripId) throws TripExceptions {
    tripService.deleteTrip(TripId);
    return"Trip deleted succesfully";
 }

}
