package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Screen {

    private final String id;
    private final List<Seat> seats;
    private final Theater theater;

    public Screen(String id, Theater theater) {

        this.id = id;
        this.theater = theater;
        this.seats = new ArrayList<>();
    }

    public void addSeat(@NonNull Seat seat) {
        seats.add(seat);
    }
}
