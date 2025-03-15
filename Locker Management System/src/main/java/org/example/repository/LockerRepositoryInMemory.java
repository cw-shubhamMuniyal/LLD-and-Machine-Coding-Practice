package org.example.repository;

import lombok.NonNull;
import org.example.model.Locker;
import org.example.model.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LockerRepositoryInMemory implements LockerRepository {

    private final List<Locker> lockers;

    public Locker getLocker(@NonNull final String id) {

        for (Locker locker : lockers) {
            if (locker.getId().equals(id)) {
                return locker;
            }
        }
        return null;
    }

    public LockerRepositoryInMemory() {
        lockers = new ArrayList<>();
    }

    @Override
    public Locker createLocker() {

        String uuid = UUID.randomUUID().toString();
        Locker locker = new Locker(uuid);
        lockers.add(locker);
        return locker;
    }

    @Override
    public List<Slot> getAvailableSlots() {

        List<Slot> availableSlots = new ArrayList<>();
        for (Locker locker : lockers) {
            availableSlots.addAll(locker.getAvailableSlots());
        }
        return availableSlots;
    }
}
