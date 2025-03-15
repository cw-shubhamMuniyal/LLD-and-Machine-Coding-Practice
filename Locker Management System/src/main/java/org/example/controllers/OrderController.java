package org.example.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.model.Customer;
import org.example.model.LockerItem;
import org.example.model.Slot;
import org.example.service.LockerService;
import org.example.service.NotificationService;
import org.example.service.OtpService;

@AllArgsConstructor
public class OrderController {

    private final LockerService lockerService;
    private final OtpService otpService;
    private final NotificationService notificationService;

    public Slot addItem(@NonNull final Customer customer, @NonNull final LockerItem lockerItem) {

        Slot slot = lockerService.addItemInSlot(lockerItem);
        String otpCode = otpService.saveSlotOtpMapping(slot);
        notificationService.sendNotification(customer.getContact(), slot, otpCode);
        return slot;
    }
}
