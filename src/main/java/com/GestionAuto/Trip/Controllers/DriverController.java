package com.GestionAuto.Trip.Controllers;

import com.GestionAuto.Trip.Exceptions.TripExceptions;
import com.GestionAuto.Trip.Services.DriverService;
import com.GestionAuto.Trip.models.Driver;
import com.GestionAuto.Trip.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DriverController {
     @Autowired
    DriverService driverService ;
     @PostMapping(path = "/addDriver")
     public Driver addDriver(@RequestBody Driver Driver  ) throws Exception {
         return driverService.AddDriver(Driver);
     }

    @PostMapping(path = "/DriversAvailable")
    public List<Driver> driversAvailable(
            @RequestParam("depart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate depart,
            @RequestParam("arriver") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate arriver) {
        return driverService.DriversAvailable(depart, arriver);
    }


}
