package com.wecp.logisticsmanagementandtrackingsystem.service;

import com.wecp.logisticsmanagementandtrackingsystem.entity.Cargo;
import com.wecp.logisticsmanagementandtrackingsystem.entity.Driver;
import com.wecp.logisticsmanagementandtrackingsystem.entity.User;
import com.wecp.logisticsmanagementandtrackingsystem.exceptions.CargosNotFoundException;
import com.wecp.logisticsmanagementandtrackingsystem.exceptions.DriverNotFoundException;
import com.wecp.logisticsmanagementandtrackingsystem.repository.CargoRepository;
import com.wecp.logisticsmanagementandtrackingsystem.repository.DriverRepository;
import com.wecp.logisticsmanagementandtrackingsystem.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DriverService {

    // Dependency Injections
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private UserRepository userRepository;

    public Driver createDriver(Driver driver) {
        // adding driver to database and return driver
        return driverRepository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        // returning list of drivers from database
        return driverRepository.findAll();

    }

    public List<Cargo> viewDriverCargos(Long driverId) throws CargosNotFoundException, DriverNotFoundException{
        // get assigned cargos of driver from database
        User user = userRepository.findById(driverId).get();
        
        Driver driver = driverRepository.findByName(user.getUsername());
        if(driver == null)
            throw new DriverNotFoundException("No driver with such username.");
        if(cargoRepository.findByDriverId(driver.getId()) != null)
            return cargoRepository.findByDriverId(driver.getId());
        else
            throw new CargosNotFoundException("No cargos associated with this driver");
    }

    public boolean updateCargoStatus(Long cargoId, String newStatus) {
        // update cargo status in database
        Cargo cargo = cargoRepository.findById(cargoId).orElseThrow(() -> new EntityNotFoundException(cargoId + " not found!!"));

        cargo.setStatus(newStatus);
        cargoRepository.save(cargo);
        return true;

    }

}