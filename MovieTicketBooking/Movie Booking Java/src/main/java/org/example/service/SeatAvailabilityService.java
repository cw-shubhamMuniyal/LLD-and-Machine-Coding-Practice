package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.model.Seat;
import org.example.model.Show;
import org.example.providers.SeatLockProvider;

import java.util.List;

@AllArgsConstructor
public class SeatAvailabilityService {

    private final BookingService bookingService;
    private final SeatLockProvider seatLockProvider;

    public List<Seat> getAvailableSeats(@NonNull final Show show) {

        List<Seat> allSeats = show.getScreen().getSeats();
        List<Seat> unAvailableSeats = getUnAvailableSeats(show);

        allSeats.removeAll(unAvailableSeats);
        return allSeats;
    }

    public List<Seat> getUnAvailableSeats(@NonNull final Show show) {

        List<Seat> seats = this.bookingService.getBookedSeats(show);
        seats.addAll(this.seatLockProvider.getLockedSeats(show));
        return seats;
    }
}
