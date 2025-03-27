package org.example.service;

import lombok.NonNull;
import org.example.exceptions.NoStoreExistsException;
import org.example.model.Location;
import org.example.model.Store;
import org.example.model.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class StoreService {

    private final Map<String, Store> stores;
    private final VehicleManagementService vehicleManagementService;

    public StoreService(@NonNull final VehicleManagementService vehicleManagementService) {
        stores = new HashMap<>();
        this.vehicleManagementService = vehicleManagementService;
    }

    public Store addStore(@NonNull final Location location) {
        String storeId = UUID.randomUUID().toString();
        Store store = new Store(storeId, location);
        stores.put(storeId, store);
        return store;
    }

    public Store getStore(@NonNull final String storeId) {
        if (!stores.containsKey(storeId)) {
            throw new NoStoreExistsException();
        }
        return stores.get(storeId);
    }

    public Vehicle addVehicle(@NonNull final Vehicle vehicle) {
        return vehicleManagementService.addVehicle(vehicle.getRegistrationNumber(),
                vehicle.getType(), vehicle.getStoreId());
    }

    public List<Vehicle> getVehicles(@NonNull final String storeId) {
        return this.vehicleManagementService.getVehiclesByStoreId(storeId);
    }
}
