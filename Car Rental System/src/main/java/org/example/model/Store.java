package org.example.model;

import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

    private final String id;
    private Location location;
    private final Map<String, Vehicle> vehicles;

    public Store(@NonNull final String id,
                 @NonNull final Location location) {

        this.id = id;
        this.vehicles = new HashMap<>();
    }

    public void addVehicle(@NonNull final Vehicle vehicle) {
        this.vehicles.put(vehicle.getRegistrationNumber(), vehicle);
    }

    public void removeVehicle(@NonNull final String registrationNumber) {
        this.vehicles.remove(registrationNumber);
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles.values().stream().toList();
    }

}
