package org.example.service;

import lombok.NonNull;
import org.example.exceptions.NoReservationExistsException;
import org.example.model.Reservation;
import org.example.model.ReservationType;
import org.example.model.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ReservationService {

    private final Map<String, Reservation> reservations;

    public ReservationService() {
        reservations = new HashMap<>();
    }

    public Reservation createReservation(@NonNull final Vehicle vehicle,
                       @NonNull final String userId,
                       @NonNull final ReservationType reservationType) {

        Reservation reservation = new Reservation(vehicle, userId, reservationType);
        String reservationId = UUID.randomUUID().toString();
        reservations.put(reservationId, reservation);
        return reservation;
    }

    public Reservation getReservation(@NonNull final String reservationId) {

        if (!reservations.containsKey(reservationId)) {
            throw new NoReservationExistsException();
        }
        return reservations.get(reservationId);
    }

    public void expireReservation(@NonNull final String reservationId) {

        if (!reservations.containsKey(reservationId)) {
            throw new NoReservationExistsException();
        }
        reservations.get(reservationId).expireReservation();
    }
}
