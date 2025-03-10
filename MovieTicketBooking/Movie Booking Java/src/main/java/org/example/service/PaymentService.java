package org.example.service;


import lombok.NonNull;
import org.example.exceptions.BadRequestException;
import org.example.model.Booking;
import org.example.providers.SeatLockProvider;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {

    private final Integer allowedRetriesCount;
    private final Map<Booking, Integer> bookingFailures;
    private final SeatLockProvider seatLockProvider;

    public PaymentService(@NonNull final Integer allowedRetriesCount, SeatLockProvider seatLockProvider) {

        this.allowedRetriesCount = allowedRetriesCount;
        bookingFailures = new HashMap<>();
        this.seatLockProvider = seatLockProvider;
    }

    public void onPaymentFailed(Booking booking, String userId) {

        if (!booking.getUserId().equals(userId)) {
            throw new BadRequestException();
        }

        if (!bookingFailures.containsKey(booking)) {
            bookingFailures.put(booking, 0);
        }

        Integer failedCount = bookingFailures.get(booking);
        bookingFailures.put(booking, failedCount+1);

        if (failedCount + 1 >= allowedRetriesCount) {

            seatLockProvider.unlockSeat(booking.getSeats(), booking.getShow(), booking.getUserId());
        }

    }
}
