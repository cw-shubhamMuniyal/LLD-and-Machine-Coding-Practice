package org.example.repository;

import lombok.NonNull;
import org.example.model.DeliveryPersonnel;

import java.util.ArrayList;
import java.util.List;

public class DeliveryPersonnelRepositoryInMemory implements DeliveryPersonnelRepository {

    private final List<DeliveryPersonnel> deliveryPersonnel;

    public DeliveryPersonnelRepositoryInMemory() {
        deliveryPersonnel = new ArrayList<>();
    }

    @Override
    public List<DeliveryPersonnel> get() {
        return deliveryPersonnel;
    }

    @Override
    public void add(@NonNull DeliveryPersonnel deliveryAgent) {
        deliveryPersonnel.add(deliveryAgent);
    }
}
