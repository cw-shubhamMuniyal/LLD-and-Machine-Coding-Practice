package org.example.service;

import lombok.NonNull;
import org.example.exceptions.NoUserExistsException;
import org.example.exceptions.NoVehicleExistsException;
import org.example.model.Vehicle;
import org.example.model.VehicleType;

import java.util.*;
import java.util.stream.Collectors;

public class VehicleManagementService {

    Map<String, Vehicle> vehicles;

    public VehicleManagementService() {
        vehicles = new HashMap<>();
    }

    public Vehicle addVehicle(@NonNull final String registrationNumber,
                              @NonNull final VehicleType type, @NonNull final String storeId) {
        Vehicle vehicle = new Vehicle(registrationNumber, type, storeId);
        vehicles.put(registrationNumber, vehicle);
        return vehicle;
    }

    public Vehicle getVehicle(@NonNull final String registrationNumber) {
        if (!vehicles.containsKey(registrationNumber)) {
            throw new NoVehicleExistsException();
        }
        return vehicles.get(registrationNumber);
    }

    public List<Vehicle> getVehiclesByStoreId(@NonNull final String storeId) {

        Collection<Vehicle> vehicleCollection = vehicles.values();
        if (vehicleCollection.isEmpty()) {
            return new ArrayList<>();
        }

        List<Vehicle> vehicleList = vehicleCollection.stream().toList();

        return vehicleList.stream()
                .filter(Objects::nonNull)
                .filter(vehicle -> storeId.equals(vehicle.getStoreId()))
                .collect(Collectors.toList());
    }
}
