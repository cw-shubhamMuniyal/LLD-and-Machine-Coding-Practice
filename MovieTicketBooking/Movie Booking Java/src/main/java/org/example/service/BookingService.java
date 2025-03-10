package org.example.service;

import lombok.NonNull;
import org.example.exceptions.BadRequestException;
import org.example.exceptions.NotFoundException;
import org.example.exceptions.SeatAlreadyBookedException;
import org.example.model.Booking;
import org.example.model.Seat;
import org.example.model.Show;
import org.example.providers.SeatLockProvider;

import java.util.*;
import java.util.stream.Collectors;

public class BookingService {

    private final Map<String, Booking> bookings;
    private final SeatLockProvider seatLockProvider;

    public BookingService(SeatLockProvider seatLockProvider) {

        this.bookings = new HashMap<>();
        this.seatLockProvider = seatLockProvider;
    }

    public Booking getBooking(String id) {

        if (!bookings.containsKey(id)) {
            throw new NotFoundException();
        }

        return bookings.get(id);
    }

    public Booking createBooking(@NonNull final String userId,
                                 @NonNull final Show show,
                                 @NonNull final List<Seat> seats) {

        if (isAnySeatAlreadyBooked(show, seats)) {
            throw new SeatAlreadyBookedException();
        }

        String id = UUID.randomUUID().toString();
        Booking booking = new Booking(id, seats, userId, show);
        bookings.put(id, booking);
        seatLockProvider.lockSeat(seats, show, userId);
        return booking;
    }

    public List<Booking> getAllBookingsForShow(@NonNull final Show show) {

        List<Booking> response = new ArrayList<>();
        for (Booking booking : bookings.values()) {

            if (booking.getShow().equals(show)) {
                response.add(booking);
            }
        }

        return response;
    }

    public List<Seat> getBookedSeats(@NonNull final Show show) {

        return this.getAllBookingsForShow(show)
                .stream()
                .filter(Booking::isConfirmed)
                .map(Booking::getSeats)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public void confirmBooking(@NonNull final  Booking booking, @NonNull final String userId) {

        if (!booking.getUserId().equals(userId)) {
            throw new BadRequestException();
        }

        for (Seat seat : booking.getSeats()) {
            boolean isLockValidated = seatLockProvider.validateSeatLock(seat, booking.getShow(), userId);
            if (!isLockValidated) {
                throw new SeatAlreadyBookedException();
            }
        }
        booking.confirmBooking();
    }

    private boolean isAnySeatAlreadyBooked(Show show, List<Seat> seats){

        List<Seat> bookedSeats = getBookedSeats(show);

        for (Seat seat : seats) {

            if (bookedSeats.contains(seat)) {
                return true;
            }
        }

        return false;
    }

}
