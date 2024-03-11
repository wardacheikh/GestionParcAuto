package com.GestionAuto.Trip.Services;

import com.GestionAuto.Trip.Exceptions.TripExceptions;
import com.GestionAuto.Trip.models.Driver;
import com.GestionAuto.Trip.models.Trip;
import com.GestionAuto.Trip.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService{
     @Autowired
     DriverRepository driverRepository;

     @Override
    public Driver AddDriver(Driver driver) throws Exception {
        Optional<Driver> driveropt = driverRepository.findById(driver.getId());
        if (driveropt.isPresent())
        {
            throw new Exception("Trip existe déjà");
        }
        else{
                return driverRepository.save(driver);
            }
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public void deleteDriver(Long id) {

    }

    @Override
    public List<Driver> getAllDriversDispo(LocalDate depard, LocalDate arriver) {
        return driverRepository.findAvailableDrivers(depard,arriver);
    }

    @Override
    public List<Driver> DriversAvailable(LocalDate depart, LocalDate arriver) {
        return driverRepository.findAvailableDrivers(depart,arriver);
    }


}
