package org.example.providers;

import org.example.model.Seat;
import org.example.model.Show;

import java.util.List;

public interface SeatLockProvider {

    void lockSeat(List<Seat> seats, Show show, String userId);
    void unlockSeat(List<Seat> seats, Show show, String userId);
    boolean validateSeatLock(Seat seat, Show show, String userId);
    List<Seat> getLockedSeats(Show show);
}
