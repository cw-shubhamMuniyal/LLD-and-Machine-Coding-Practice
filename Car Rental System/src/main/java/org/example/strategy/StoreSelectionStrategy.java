package org.example.strategy;

import lombok.NonNull;
import org.example.model.Location;
import org.example.model.Store;

import java.util.List;

public interface StoreSelectionStrategy {
    Store fetchStore(@NonNull final List<Store> stores);
}
