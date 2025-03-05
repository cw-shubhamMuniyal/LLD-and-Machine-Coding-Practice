package org.example.service;

import org.example.model.Driver;
import org.example.model.DriverStatus;
import org.example.model.Location;

import java.util.*;

public class DriverService {

    Map<String, Driver> drivers = new HashMap<>();

    public String register(String phoneNumber, Location location) {

        String userId = UUID.randomUUID().toString().replace("-", "");
        Driver driver = new Driver(userId, phoneNumber, DriverStatus.UNAVAILABLE, location);
        drivers.put(userId, driver);
        return userId;
    }

    public void updateAvailability(String id, DriverStatus status) {
        Driver driver = drivers.get(id);
        if (Objects.nonNull(driver)) {
            driver.updateStatus(status);
        }
    }

    public void updateLocation(String id, Location location) {
        Driver driver = drivers.get(id);
        if (Objects.nonNull(driver)) {
            driver.updateLocation(location);
        }
    }

    public Map<String, Driver> fetchDriversByFilters(Driver driver) {

        Map<String, Driver> drivers = new HashMap<>();

        for (Map.Entry<String, Driver> entry : this.drivers.entrySet()) {

            DriverStatus driverStatus = driver.getDriverStatus();

            if (Objects.nonNull(driverStatus)) {
                if (entry.getValue().getDriverStatus().equals(driverStatus)) {
                    drivers.put(entry.getKey(), entry.getValue());
                }
            }

            Location location = driver.getLocation();

            if (Objects.nonNull(location)) {
                if (
                        entry.getValue().getLocation().getXCoordinate() == location.getXCoordinate()
                                && entry.getValue().getLocation().getYCoordinate() == location.getYCoordinate()
                ) {
                    drivers.put(entry.getKey(), entry.getValue());
                }
            }

        }

        return drivers;
    }

    public Map<String, Driver> fetchNearByDrivers(Location source, Double radius) {

        Map<String, Driver> nearByDrivers = new HashMap<>();

        for (Map.Entry<String, Driver> entry : this.drivers.entrySet()) {

            Double distance = entry.getValue().getLocation().computeDistance(source);
            if (distance <= radius
            && DriverStatus.IDLE.equals(entry.getValue().getDriverStatus())) {
                nearByDrivers.put(entry.getKey(), entry.getValue());
            }
        }

        return nearByDrivers;
    }

    public Driver fetchDriver(String driverId) {
        return this.drivers.get(driverId);
    }


}
