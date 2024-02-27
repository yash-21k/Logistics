package com.wecp.logisticsmanagementandtrackingsystem.service;

import com.wecp.logisticsmanagementandtrackingsystem.entity.Cargo;
import com.wecp.logisticsmanagementandtrackingsystem.entity.Driver;
import com.wecp.logisticsmanagementandtrackingsystem.repository.CargoRepository;
import com.wecp.logisticsmanagementandtrackingsystem.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepo;

    @Autowired
    private DriverRepository driverRepo;

    public Cargo addCargo(Cargo cargo) {
        return this.cargoRepo.save(cargo);
    }

    public List<Cargo> viewAllCargos() {
       // get all cargos from database
       return this.cargoRepo.findAll();
    }

    public boolean assignCargoToDriver(Long cargoId, Long driverId) {
        Cargo cargo = cargoRepo.findById(cargoId).orElseThrow(() -> new EntityNotFoundException("Cargo with ID "+cargoId+" not found!"));

        Driver driver = driverRepo.findById(driverId).orElseThrow(() -> new EntityNotFoundException("Driver with ID "+driverId+" not found!"));

        cargo.setDriver(driver);
        cargoRepo.save(cargo);
        return true;
        //assign cargo to driver
    }
}