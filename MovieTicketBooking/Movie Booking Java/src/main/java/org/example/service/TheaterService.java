package org.example.service;

import lombok.NonNull;
import org.example.exceptions.NotFoundException;
import org.example.model.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class TheaterService {

    Map<String, Theater> theaters = new HashMap<>();
    Map<String, Screen> screens = new HashMap<>();
    Map<String, Seat> seats = new HashMap<>();

    public Theater addTheater(@NonNull final String theaterName) {

        String id = UUID.randomUUID().toString();
        Theater theater = new Theater(id, theaterName);
        theaters.put(id, theater);
        return theater;
    }

    public Theater getTheater(@NonNull final String theaterId) {

        if (!theaters.containsKey(theaterId)) {
            throw  new NotFoundException();
        }

        return this.theaters.get(theaterId);
    }

    public Seat addSeatsInScreen(@NonNull final Integer rowNumber, @NonNull final Integer columnNumber,
                                 @NonNull final Screen screen) {

        String id = UUID.randomUUID().toString();
        Seat seat = new Seat(id, rowNumber, columnNumber);
        seats.put(id, seat);
        screen.addSeat(seat);
        return seat;
    }

    public Seat getSeat(@NonNull final String seatId) {

        if (!seats.containsKey(seatId)) {
            throw  new NotFoundException();
        }

        return this.seats.get(seatId);
    }

    public Screen addScreenInTheater(@NonNull final Theater theater) {

        String id = UUID.randomUUID().toString();
        Screen screen = new Screen(id, theater);
        screens.put(id, screen);
        theater.addScreen(screen);
        return screen;
    }

    public Screen getScreen(@NonNull final String screenId) {

        if (!seats.containsKey(screenId)) {
            throw  new NotFoundException();
        }

        return this.screens.get(screenId);
    }

}
