package org.example.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import org.example.exceptions.SlotAlreadyOccupiedException;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
public class Slot {

    private final String id;
    private final Size size;
    private final Locker locker;
    private LockerItem lockerItem;
    private LocalDateTime itemPlacementDate;

    public Slot(@NonNull final String id,
                @NonNull final Size size,
                @NonNull final Locker locker) {

        this.id = id;
        this.size = size;
        this.locker = locker;
    }

    public void addItem(LockerItem lockerItem, LocalDateTime dateTime) {

        if (Objects.nonNull(this.lockerItem)) {
            throw new SlotAlreadyOccupiedException();
        }

        this.lockerItem = lockerItem;
        this.itemPlacementDate = dateTime;
    }

    public boolean isSlotAvailable() {
        return Objects.isNull(lockerItem);
    }

    public void removeItem() {
        this.lockerItem = null;
    }
}
