package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.model.DriverStatus;
import org.example.model.Location;
import org.example.model.Ride;
import org.example.service.RideService;
import org.example.service.RiderService;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class RiderController {

    private final RiderService riderService;

    private final RideService rideService;

    public String register(String phoneNumber) {

        return riderService.register(phoneNumber);
    }

    public void bookCab(String riderId, Location source, Location destination) {

        riderService.bookCab(riderId, source, destination);
    }

    public List<Ride> fetchRideHistory(String riderId) {
        return rideService.fetchRideHistory(riderId);
    }
}
