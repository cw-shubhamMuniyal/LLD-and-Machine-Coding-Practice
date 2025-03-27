package org.example.model;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Vehicle {

    public Vehicle(@NonNull final String registrationNumber,
                   @NonNull final VehicleType type,
                   @NonNull final String storeId) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.storeId = storeId;
    }

    private final String registrationNumber;
    private final VehicleType type;
    private final String storeId;
}
