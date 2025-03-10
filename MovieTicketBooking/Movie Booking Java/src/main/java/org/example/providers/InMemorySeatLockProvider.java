package org.example.providers;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import org.example.exceptions.SeatNotAvailableException;
import org.example.model.Seat;
import org.example.model.SeatLock;
import org.example.model.Show;

import java.time.LocalDateTime;
import java.util.*;

public class InMemorySeatLockProvider implements SeatLockProvider {

    private final Map<Show, Map<Seat, SeatLock>> seatLocks;
    private final Integer lockTimeOut;

    public InMemorySeatLockProvider(Integer lockTimeOut) {
        seatLocks = new HashMap<>();
        this.lockTimeOut = lockTimeOut;
    }

    @Override
    public void lockSeat(final @NonNull List<Seat> seats, final @NonNull Show show, final @NonNull String userId) {

        for (Seat seat : seats) {
            if (isSeatLocked(show, seat)) {
                throw new SeatNotAvailableException("seat not available at this moment!");
            }
        }

        for (Seat seat : seats) {
            lockSeat(seat, show, userId);
        }

    }

    @Override
    public void unlockSeat(List<Seat> seats, Show show, String userId) {

        for (Seat seat : seats) {
            if (validateSeatLock(seat, show, userId)) {
                removeSeat(seat, show, userId);
            }
        }
    }

    @Override
    public boolean validateSeatLock(Seat seat, Show show, String userId) {
        return isSeatLocked(show, seat) && this.seatLocks.get(show).get(seat).getLockedBy().equals(userId);
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {

        if (!seatLocks.containsKey(show)) {
            return ImmutableList.of();
        }

        final List<Seat> lockedSeats = new ArrayList<>();

        for (Map.Entry<Seat, SeatLock> seatLockEntry : seatLocks.get(show).entrySet()) {

            Seat seat = seatLockEntry.getKey();

            if (isSeatLocked(show, seat)) {
                lockedSeats.add(seatLockEntry.getKey());
            }
        }

        return lockedSeats;
    }

    private void lockSeat(final Seat seat, final Show show, final String userId) {


        if (!this.seatLocks.containsKey(show)) {
            this.seatLocks.put(show, new HashMap<>());
        }
        SeatLock seatLock = new SeatLock(seat, show, LocalDateTime.now(), lockTimeOut, userId);
        this.seatLocks.get(show).put(seat, seatLock);
    }

    private void removeSeat(final Seat seat, final Show show, final String userId) {

        if (!seatLocks.containsKey(show)) {
            return;
        }
        this.seatLocks.get(show).put(seat, null);
    }

    private boolean isSeatLocked(final Show show, final Seat seat) {

        if (seatLocks.containsKey(show)) {

            Map<Seat, SeatLock> seatLockMap = seatLocks.get(show);
            if (Objects.nonNull(seatLockMap.get(seat))) {
                return !seatLockMap.get(seat).isLockExpired();
            }
        }

        return false;
    }

}
