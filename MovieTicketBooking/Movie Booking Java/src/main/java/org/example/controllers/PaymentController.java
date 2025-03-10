package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.model.Booking;
import org.example.service.BookingService;
import org.example.service.PaymentService;

@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final BookingService bookingService;

    public void onPaymentSuccess(String bookingId, String userId) {

        Booking booking = bookingService.getBooking(bookingId);
        bookingService.confirmBooking(booking, userId);
    }

    public void onPaymentFailure(String bookingId, String userId) {

        Booking booking = bookingService.getBooking(bookingId);
        paymentService.onPaymentFailed(booking, userId);
    }
}
