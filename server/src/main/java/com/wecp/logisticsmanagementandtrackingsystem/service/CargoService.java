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

    //function to add new cargo
    public Cargo addCargo(Cargo cargo) {
        return this.cargoRepo.save(cargo);
    }

    //function to return list of all cargos
    public List<Cargo> viewAllCargos() {
       // get all cargos from database
       return this.cargoRepo.findAll();
    }

    //function to assign cargo to driver based on their IDs
    public boolean assignCargoToDriver(Long cargoId, Long driverId) {

        //check if the cargo exists in database based on cargo id, else throw error
        Cargo cargo = cargoRepo.findById(cargoId).orElseThrow(() -> new EntityNotFoundException("Cargo with ID "+cargoId+" not found!"));

        //check if the driver exists in database based on driver id, else throw error
        Driver driver = driverRepo.findById(driverId).orElseThrow(() -> new EntityNotFoundException("Driver with ID "+driverId+" not found!"));
<<<<<<< HEAD

        //if the driver and cargo are found, assign cargo to driver and return true.
=======
        cargo.setStatus("Order Assigned");
>>>>>>> da50e49a50c525ff88ad1b5e7f45b25cd602b482
        cargo.setDriver(driver);
        cargoRepo.save(cargo);
        return true;
    }
}