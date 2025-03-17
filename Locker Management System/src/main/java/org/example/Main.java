package org.example;

import org.example.controllers.LockerController;
import org.example.controllers.OrderController;
import org.example.controllers.ReturnController;
import org.example.model.*;
import org.example.model.Package;
import org.example.repository.*;
import org.example.service.DeliveryService;
import org.example.service.LockerService;
import org.example.service.NotificationService;
import org.example.service.OtpService;
import org.example.strategies.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Practicing Locker management system LLD!");


        SlotAssignmentStrategy slotAssignmentStrategy = new RandomSlotAssignmentStrategy();
        SlotFilteringStrategy slotFilteringStrategy = new SlotFilteringBySizeStrategy();
        OtpGeneratorStrategy otpGeneratorStrategy = new RandomOtpGeneratorStrategy();
        DeliveryPersonnelPickingStrategy deliveryPersonnelPickingStrategy = new DefaultDeliveryPersonnelPickingStrategy();

        LockerRepository lockerRepository = new LockerRepositoryInMemory();
        SlotOtpRepository slotOtpRepository = new SlotOtpRepositoryInMemory();
        DeliveryPersonnelRepository deliveryPersonnelRepository = new DeliveryPersonnelRepositoryInMemory();

        LockerService lockerService = new LockerService(
                lockerRepository,
                slotFilteringStrategy,
                slotAssignmentStrategy
        );
        OtpService otpService = new OtpService(
                otpGeneratorStrategy,
                slotOtpRepository
        );
        NotificationService notificationService = new NotificationService();
        DeliveryService deliveryService = new DeliveryService(
                deliveryPersonnelPickingStrategy,
                deliveryPersonnelRepository
        );

        LockerController lockerController = new LockerController(lockerService, otpService);

        Locker locker1 = lockerController.createLocker();
        Locker locker2 = lockerController.createLocker();

        lockerController.addSlot(locker1, new Size(10.0, 10.0));
        lockerController.addSlot(locker1, new Size(5.0, 5.0));

        lockerController.addSlot(locker2, new Size(20.0, 20.0));
        lockerController.addSlot(locker2, new Size(30.0, 30.0));

        deliveryPersonnelRepository.add(new DeliveryPersonnel("1", new Contact("9088765543")));
        deliveryPersonnelRepository.add(new DeliveryPersonnel("2", new Contact("9088765543")));

        OrderController orderController = new OrderController(
                lockerService,
                otpService,
                notificationService
        );

        ReturnController returnController = new ReturnController(
                lockerService,
                otpService,
                notificationService,
                deliveryService);

        Contact contact = new Contact("9876543212");
        Customer customer = new Customer("tom_riddle", contact);

        LockerItem lockerItem1 = new Package("bag", new Size(10.0, 15.0));
        LockerItem lockerItem2 = new Package("TV", new Size(100.0, 150.0));

//        Customer adding items in locker

        try {
            orderController.addItem(customer, lockerItem1);
        } catch (Exception e) {
            System.out.println("slot already occupied, please try after some time!");
        }

        try {
            orderController.addItem(customer, lockerItem2);
        } catch (Exception e) {
            System.out.println("slot already occupied, please try after some time!");
        }

//        Customer returning objects in locker
        returnController.returnItem(lockerItem1);

    }
}