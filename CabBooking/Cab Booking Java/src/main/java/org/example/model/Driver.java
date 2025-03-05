package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
//@Builder
public class Driver extends User {

    public Driver(String id, String phoneNumber, DriverStatus status, Location location) {
        super(id, phoneNumber);
        this.updateLocation(location);
        this.updateStatus(status);
    }

    private DriverStatus driverStatus;

    private Location location;

    public void updateStatus(DriverStatus status) {
        this.driverStatus = status;
    }

    public void updateLocation(Location location) {
        this.location = location;
    }

    public void endTrip() {
        this.driverStatus = DriverStatus.IDLE;
    }

}
