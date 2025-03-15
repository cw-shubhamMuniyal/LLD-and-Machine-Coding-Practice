package org.example.strategies;

import lombok.NonNull;
import org.example.model.LockerItem;
import org.example.model.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class SlotFilteringBySizeStrategy implements SlotFilteringStrategy {

    @Override
    public List<Slot> fetchSlotsByFilter(@NonNull List<Slot> slots,
                                         @NonNull final LockerItem lockerItem) {

        return slots.stream()
                .filter(slot -> slot.getSize().canAccomodate(lockerItem.getSize()))
                .collect(Collectors.toList());
    }
}
