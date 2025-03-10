package org.example.model;

import lombok.Getter;
import lombok.NonNull;
import org.example.exceptions.BookingNotCreated;

import java.util.List;

@Getter
public class Booking {

    private final String id;
    private final List<Seat> seats;
    private final String userId;
    private final Show show;
    private BookingStatus bookingStatus;

    public Booking(@NonNull final String id,
                   @NonNull final List<Seat> seats,
                   @NonNull final String userId,
                   @NonNull final Show show) {

        this.id = id;
        this.seats = seats;
        this.userId = userId;
        this.show = show;
        this.bookingStatus = BookingStatus.CREATED;
    }

    public boolean isConfirmed() {
        return this.bookingStatus == BookingStatus.CONFIRMED;
    }

    public void confirmBooking() {

        if (!BookingStatus.CREATED.equals(this.bookingStatus)) {
            throw new BookingNotCreated();
        }

        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void expireBooking() {

        if (!BookingStatus.CREATED.equals(this.bookingStatus)) {
            throw new BookingNotCreated();
        }

        this.bookingStatus = BookingStatus.EXPIRED;
    }

}
