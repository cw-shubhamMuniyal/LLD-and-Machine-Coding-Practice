package org.example.repository;

import lombok.NonNull;
import org.example.model.Locker;
import org.example.model.Slot;

import java.util.List;

public interface LockerRepository {

    Locker getLocker(@NonNull final String id);
    Locker createLocker();
    List<Slot> getAvailableSlots();
}
