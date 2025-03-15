package org.example.strategies;

import lombok.NonNull;
import org.example.model.Slot;
import org.example.utils.RandomNumberGenerator;

import java.util.List;

public class RandomSlotAssignmentStrategy implements SlotAssignmentStrategy {

    @Override
    public Slot pickSlot(@NonNull List<Slot> slots) {

        Integer randomIndex = RandomNumberGenerator.getRandomNumber(slots.size());
        return slots.get(randomIndex);
    }
}
