package org.example.strategies;

import lombok.NonNull;
import org.example.model.DeliveryPersonnel;
import org.example.model.Slot;

import java.util.List;

public interface DeliveryPersonnelPickingStrategy {
    DeliveryPersonnel pickDeliveryAgent(@NonNull final List<DeliveryPersonnel> deliveryPersonnel,
                                        @NonNull final Slot slot);
}
