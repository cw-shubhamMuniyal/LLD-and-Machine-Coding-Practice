package org.example.strategies;

import lombok.NonNull;
import org.example.model.DeliveryPersonnel;
import org.example.model.Slot;

import java.util.List;

public class DefaultDeliveryPersonnelPickingStrategy implements DeliveryPersonnelPickingStrategy {

    @Override
    public DeliveryPersonnel pickDeliveryAgent(@NonNull List<DeliveryPersonnel> deliveryPersonnel,
                                               @NonNull final Slot slot) {
        return deliveryPersonnel.getFirst();
    }
}
