package org.example.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.model.Customer;
import org.example.model.DeliveryPersonnel;
import org.example.model.LockerItem;
import org.example.model.Slot;
import org.example.service.DeliveryService;
import org.example.service.LockerService;
import org.example.service.NotificationService;
import org.example.service.OtpService;

@AllArgsConstructor
public class ReturnController {

    private final LockerService lockerService;
    private final OtpService otpService;
    private final NotificationService notificationService;
    private final DeliveryService deliveryService;

    Slot returnItem(@NonNull final LockerItem lockerItem) {

        Slot slot = lockerService.addItemInSlot(lockerItem);
        String otpCode = otpService.saveSlotOtpMapping(slot);
        DeliveryPersonnel deliveryPersonnel = deliveryService.fetchDeliveryPersonnel(slot);
        notificationService.sendNotification(deliveryPersonnel.getContact(), slot, otpCode);
        return slot;
    }
}
