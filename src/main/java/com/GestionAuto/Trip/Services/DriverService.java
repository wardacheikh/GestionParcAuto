package com.GestionAuto.Trip.Services;

import com.GestionAuto.Trip.models.Driver;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface DriverService {
    public Driver AddDriver(Driver driver ) throws Exception;
    public List<Driver> getAllDrivers();
    public void deleteDriver(Long id) ;
    public List<Driver> getAllDriversDispo(LocalDate depard , LocalDate arriver);
    public List<Driver>DriversAvailable( LocalDate depart ,  LocalDate arriver);

    }
