package org.example.service.strategies;

import org.example.model.Driver;
import org.example.model.Location;
import org.example.service.DriverService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FirstDriverMatchingStrategy implements DriverMatchingStrategy {

    DriverService driverService;

    public static final double RADIUS = 100.0;

    public FirstDriverMatchingStrategy(DriverService driverService) {
        this.driverService = driverService;
    }

    @Override
    public Driver fetchDriver(Location sourceLocation) {

        Map<String, Driver> nearByDrivers = findNearByDrivers(sourceLocation);

        if (Objects.nonNull(nearByDrivers)) {
            List<Driver> drivers = nearByDrivers.values().stream().toList();

            if (!drivers.isEmpty()) {
                return drivers.getFirst();
            }
        }

        return null;
    }

    private Map<String, Driver> findNearByDrivers(Location source) {

        return this.driverService.fetchNearByDrivers(source, RADIUS);
    }
}
