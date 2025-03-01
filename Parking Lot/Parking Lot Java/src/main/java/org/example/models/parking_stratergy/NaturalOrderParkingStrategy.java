package org.example.models.parking_stratergy;

import org.example.exceptions.NoSlotAvailableException;

import java.util.TreeSet;

public class NaturalOrderParkingStrategy  implements ParkingStrategy{

    private final TreeSet<Integer> slots;

    public NaturalOrderParkingStrategy() {
        slots = new TreeSet<>();
    }

    @Override
    public void addSlot(Integer id) {
        slots.add(id);
    }

    @Override
    public void removeSlot(Integer id) {
        slots.remove(id);
    }

    @Override
    public Integer getNextFreeSlot() throws Exception {

        if (slots.isEmpty()) {
            throw new NoSlotAvailableException("No slot available!");
        }
        return slots.first();
    }
}
