package org.example.strategies;

import lombok.NonNull;
import org.example.model.Slot;

import java.util.List;

public interface SlotAssignmentStrategy {

    Slot pickSlot(@NonNull final List<Slot> slots);
}
