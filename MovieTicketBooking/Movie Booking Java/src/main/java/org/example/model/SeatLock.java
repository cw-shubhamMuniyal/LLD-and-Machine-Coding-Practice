package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class SeatLock {

    private final Seat seat;
    private final Show show;
    private final LocalDateTime lockTime;
    private final Integer durationInMinutes;
    private final String lockedBy;

    public boolean isLockExpired() {

        LocalDateTime lockEndTime = lockTime.plus(Duration.ofMinutes(durationInMinutes));
        return LocalDateTime.now().isAfter(lockEndTime);
    }
}
