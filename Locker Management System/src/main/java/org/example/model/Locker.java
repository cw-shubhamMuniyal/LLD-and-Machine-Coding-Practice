package org.example.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Locker {

    private final List<Slot> slots;
    private final String id;

    public Locker(@NonNull final String id) {
        this.id = id;
        this.slots = new ArrayList<>();
    }

    public void addSlot(@NonNull final Slot slot) {
        this.slots.add(slot);
    }

    public List<Slot> getAvailableSlots() {

        List<Slot> availableSlots = new ArrayList<>();

        for (Slot slot : slots) {
            if (slot.isSlotAvailable()) {
                availableSlots.add(slot);
            }
        }

        return availableSlots;
    }

}
