package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.Driver;
import org.example.model.Location;
import org.example.model.Rider;
import org.example.service.strategies.DriverMatchingStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class RiderService {

    Map<String, Rider> riders = new HashMap<>();

    private final RideService rideService;

    private final DriverMatchingStrategy driverMatchingStrategy;

    public RiderService(RideService rideService, DriverMatchingStrategy driverMatchingStrategy) {
        this.driverMatchingStrategy = driverMatchingStrategy;
        this.rideService = rideService;
    }

    public String register(String phoneNumber) {

        String riderId = UUID.randomUUID().toString().replace("-", "");
        Rider rider = new Rider(riderId, phoneNumber);
        riders.put(riderId, rider);
        return riderId;
    }

    public void bookCab(String riderId, Location source, Location destination) {

        Driver matchedDriver = this.driverMatchingStrategy.fetchDriver(source);
        if (Objects.nonNull(matchedDriver)) {
            rideService.createRide(riderId, matchedDriver, source,destination);
            System.out.println("Cab booked with id:" + matchedDriver.getId() + " for rider id:" + riderId);
        }
        else {
            System.out.println("No Drivers found! please try after some time.");
        }
    }
}
