package org.example.service;

import org.example.model.Driver;
import org.example.model.DriverStatus;
import org.example.model.Location;
import org.example.model.Ride;
import org.example.service.strategies.PricingStrategy;

import java.util.*;

public class RideService {

    Map<String, List<Ride>> rides = new HashMap<>();

    PricingStrategy pricingStrategy;

    public RideService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void createRide(String riderId, Driver driver, Location source, Location destination) {

        Double rideFare = this.pricingStrategy.computePrice(source, destination);
        List<Ride> rideList = rides.getOrDefault(riderId, null);

        if (Objects.nonNull(rideList) && !rideList.isEmpty()) {
            rideList.add(new Ride(riderId, driver.getId(), source, destination, rideFare));
        } else {
            rides.put(
                    riderId,
                    Collections.singletonList(
                            new Ride(riderId, driver.getId(), source, destination, rideFare)
                    )
            );
        }
        driver.updateStatus(DriverStatus.ACTIVE);
    }

    public void endRide(Driver driver) throws Exception {

        if (Objects.isNull(driver)) {
            throw new RuntimeException("No driver found!");
        }

        DriverStatus driverStatus = driver.getDriverStatus();
        if (!DriverStatus.ACTIVE.equals(driverStatus)) {
            throw new RuntimeException("No active riders found fpr driver id:" + driver.getId());
        }

        System.out.println("Ride ended for driver id: " + driver.getId());
        driver.endTrip();
    }

    public List<Ride> fetchRideHistory(String riderId) {
        return this.rides.get(riderId);
    }
}
