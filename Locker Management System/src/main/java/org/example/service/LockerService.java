package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.model.Locker;
import org.example.model.LockerItem;
import org.example.model.Size;
import org.example.model.Slot;
import org.example.repository.LockerRepository;
import org.example.strategies.SlotAssignmentStrategy;
import org.example.strategies.SlotFilteringStrategy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class LockerService {

    private final LockerRepository lockerRepository;
    private final SlotFilteringStrategy slotFilteringStrategy;
    private final SlotAssignmentStrategy slotAssignmentStrategy;

    public Locker createLocker() {
        return lockerRepository.createLocker();
    }

    public Slot addSlot(@NonNull final Locker locker, @NonNull final Size size) {

        String id = UUID.randomUUID().toString();
        Slot slot = new Slot(id, size, locker);
        locker.addSlot(slot);
        return slot;
    }

    public List<Slot> getAvailableSlots() {
        return lockerRepository.getAvailableSlots();
    }

    public void removeItemFromSlot(@NonNull final Slot slot) {
        slot.removeItem();
    }

    public Slot addItemInSlot(@NonNull final LockerItem lockerItem) {
        List<Slot> availableSlots = getAvailableSlots();
        List<Slot> slots = slotFilteringStrategy.fetchSlotsByFilter(availableSlots, lockerItem);
        Slot slot = slotAssignmentStrategy.pickSlot(slots);
        slot.addItem(lockerItem, LocalDateTime.now());
        return slot;
    }

}
