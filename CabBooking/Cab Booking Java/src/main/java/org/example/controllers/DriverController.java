package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.model.Driver;
import org.example.model.DriverStatus;
import org.example.model.Location;
import org.example.service.DriverService;
import org.example.service.RideService;

import java.util.Map;

@AllArgsConstructor
public class DriverController {

    private final DriverService driverService;

    private final RideService rideService;

    public String register(String phoneNumber, Location location) {

        return this.driverService.register(phoneNumber, location);
    }

    public void updateAvailability(String driverId, DriverStatus status) {

        this.driverService.updateAvailability(driverId, status);
    }

    public void updateLocation(String driverId, Location location) {

        this.driverService.updateLocation(driverId, location);
    }

    public void endRide(Driver driver) throws Exception {
        this.rideService.endRide(driver);
    }
}
