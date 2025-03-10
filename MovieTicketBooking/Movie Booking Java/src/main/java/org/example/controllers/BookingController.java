package org.example.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.model.Booking;
import org.example.model.Seat;
import org.example.model.Show;
import org.example.service.BookingService;
import org.example.service.ShowService;
import org.example.service.TheaterService;

import java.util.List;

@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final ShowService showService;
    private final TheaterService theaterService;

    public Booking createBooking(@NonNull final String showId,
                                 @NonNull final String userId,
                                 @NonNull final List<String> seatIds) {

        List<Seat> seats = seatIds.stream().map(theaterService::getSeat).toList();
        Show show = showService.getShow(showId);
        return bookingService.createBooking(userId, show, seats);
    }
}
