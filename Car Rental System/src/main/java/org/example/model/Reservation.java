package org.example.model;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class Reservation {

    private final Vehicle vehicle;
    private final String userId;
    private final ReservationType type;
    private final LocalDateTime reservationTime;
    private ReservationStatus status;

    public Reservation(@NonNull final Vehicle vehicle,
                       @NonNull final String userId,
                       @NonNull final ReservationType type) {

        this.vehicle = vehicle;
        this.userId = userId;
        this.type = type;
        this.reservationTime = LocalDateTime.now();
        status = ReservationStatus.ACTIVE;
    }

    public void expireReservation() {
        this.status = ReservationStatus.EXPIRED;
    }
}
