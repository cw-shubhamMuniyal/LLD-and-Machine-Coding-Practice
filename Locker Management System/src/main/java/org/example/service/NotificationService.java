package org.example.service;

import org.example.model.Contact;
import org.example.model.Slot;

public class NotificationService {

    public void sendNotification(Contact contact, Slot slot, String otp) {
        System.out.println("Dear " + contact.getPhoneNumber() + " your item is placed in locker successfully." +
                "Slot Details are:" + slot + " and OTP code is " + otp);
    }
}
