package org.example.strategy;

import lombok.NonNull;
import org.example.model.Store;

import java.util.List;

public class DefaultStoreSelectionStrategy implements StoreSelectionStrategy{


    @Override
    public Store fetchStore(@NonNull List<Store> stores) {

        if (stores.isEmpty()) {
            return null;
        }

        return stores.getFirst();
    }
}
