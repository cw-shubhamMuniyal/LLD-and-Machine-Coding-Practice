package org.example.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.model.Locker;
import org.example.model.LockerItem;
import org.example.model.Size;
import org.example.model.Slot;
import org.example.service.LockerService;
import org.example.service.OtpService;

import java.util.List;

@AllArgsConstructor
public class LockerController {

    private final LockerService lockerService;
    private final OtpService otpService;

    public Locker createLocker() {
        return lockerService.createLocker();
    }

    public Slot addSlot(@NonNull final Locker locker, @NonNull final Size size) {
        return lockerService.addSlot(locker, size);
    }

    public List<Slot> getAvailableSlots() {
        return lockerService.getAvailableSlots();
    }

    public void emptySlot(@NonNull final Slot slot) {
        lockerService.removeItemFromSlot(slot);
    }

    public boolean unlockSLot(@NonNull final Slot slot, @NonNull final String otp) {
       return otpService.validateOtp(slot, otp);
    }

}
