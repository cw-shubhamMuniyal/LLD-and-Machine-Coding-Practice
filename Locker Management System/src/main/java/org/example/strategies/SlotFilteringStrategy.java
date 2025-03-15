package org.example.strategies;

import lombok.NonNull;
import org.example.model.LockerItem;
import org.example.model.Slot;

import java.util.List;

public interface SlotFilteringStrategy {

    List<Slot> fetchSlotsByFilter(@NonNull final List<Slot> slots,
                                  @NonNull final LockerItem lockerItem);
}
