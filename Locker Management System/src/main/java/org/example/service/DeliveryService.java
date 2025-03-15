package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.model.DeliveryPersonnel;
import org.example.model.Slot;
import org.example.repository.DeliveryPersonnelRepository;
import org.example.strategies.DeliveryPersonnelPickingStrategy;

import java.util.List;

@AllArgsConstructor
public class DeliveryService {

    private final DeliveryPersonnelPickingStrategy deliveryPersonnelPickingStrategy;
    private final DeliveryPersonnelRepository deliveryPersonnelRepository;

    public DeliveryPersonnel fetchDeliveryPersonnel(@NonNull final Slot slot) {

        List<DeliveryPersonnel> deliveryPersonnel = deliveryPersonnelRepository.get();
        return deliveryPersonnelPickingStrategy.pickDeliveryAgent(deliveryPersonnel, slot);
    }
}
