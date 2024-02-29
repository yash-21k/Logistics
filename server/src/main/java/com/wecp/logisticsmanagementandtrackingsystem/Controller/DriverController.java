package com.wecp.logisticsmanagementandtrackingsystem.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.wecp.logisticsmanagementandtrackingsystem.entity.Cargo;
import com.wecp.logisticsmanagementandtrackingsystem.service.DriverService;

import java.util.List;
 
@RestController
@RequestMapping
public class DriverController {
 
    @Autowired
    private DriverService driverService;
 
    @GetMapping("/api/driver/cargo")
    //@PreAuthorize("hasAuthority('DRIVER')")
    public ResponseEntity<List<Cargo>> viewAssignedCargos(@RequestParam Long driverId) {
        // get assigned cargos for the driver and return with 200 OK
        return new ResponseEntity<>(driverService.viewDriverCargos(driverId),HttpStatus.OK);
    }
 
    @PutMapping("api/driver/update-cargo-status")
    //@PreAuthorize("hasAuthority('DRIVER')")
    public ResponseEntity<String> updateCargoStatus(@RequestParam Long cargoId, @RequestParam String newStatus) {
        // update the cargo status
        cargoId = (Long)cargoId;
        boolean updateSuccess = driverService.updateCargoStatus(cargoId, newStatus);
 
        if (updateSuccess) {
            // id cargo update sucessfully return this
            return ResponseEntity.ok().body("{\"message\": \"Cargo status updated successfully.\"}");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update cargo status.");
        }
    }
 
 
}