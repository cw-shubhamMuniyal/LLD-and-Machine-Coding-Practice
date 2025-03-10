package org.example.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.model.Screen;
import org.example.model.Seat;
import org.example.model.Theater;
import org.example.service.TheaterService;

@AllArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    public Theater addTheater(@NonNull final String theaterName) {

        return theaterService.addTheater(theaterName);
    }

    public Seat addSeatInScreen(@NonNull final Integer rowNumber, @NonNull final Integer columnNumber,
                                 @NonNull final String screenId) {

        Screen screen = theaterService.getScreen(screenId);
        return theaterService.addSeatInScreen(rowNumber, columnNumber, screen);
    }

    public Screen addScreenInTheater(@NonNull final String theaterId) {

        Theater theater = theaterService.getTheater(theaterId);
        return theaterService.addScreenInTheater(theater);
    }
}
