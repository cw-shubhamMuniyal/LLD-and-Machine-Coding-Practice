package org.example.models;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


public class ParkingLot {

    @Getter
    private final Map<Integer, Slot> slots;
    private final Integer capacity;

    public ParkingLot(Integer capacity) {
        slots = new HashMap<>();
        this.capacity = capacity;
    }

    Slot getSlot(Integer slotId) throws Exception {

        if (slotId >= capacity) {
            throw new Exception("slot id is crossing threshold of parking lot!");
        }

        if (this.slots.containsKey(slotId)) {
            return slots.get(slotId);
        }
        Slot slot = new Slot(slotId);
        slots.put(slotId, slot);
        return slot;
    }

    public void addCar(Car car, Integer slotId) throws Exception {
        Slot slot = getSlot(slotId);
        if (slot.isSlotFree()) {
            slot.assignCar(car);
        }
        else {
            throw new Exception("slot with id:" + slotId + "not free");
        }
    }

    public void removeCar(Integer slotId) throws Exception {
        Slot slot = getSlot(slotId);
        slot.unassignCar();
    }

}
