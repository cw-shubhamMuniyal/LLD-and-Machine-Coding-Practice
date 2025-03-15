package org.example.repository;

import lombok.NonNull;
import org.example.model.DeliveryPersonnel;

import java.util.List;

public interface DeliveryPersonnelRepository {

    List<DeliveryPersonnel> get();

    void add(@NonNull final DeliveryPersonnel deliveryPersonnel);
}
