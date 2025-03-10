package org.example.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.model.*;
import org.example.service.MovieService;
import org.example.service.SeatAvailabilityService;
import org.example.service.ShowService;
import org.example.service.TheaterService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ShowController {

    private final ShowService showService;
    private final MovieService movieService;
    private final TheaterService theaterService;
    private final SeatAvailabilityService seatAvailabilityService;

    public Show addShowInScreen(@NonNull final String movieId,
                                @NonNull final Integer durationInMinutes,
                                @NonNull final LocalDateTime startTime, String screenId) {

        Movie movie = movieService.getMovie(movieId);
        Screen screen = theaterService.getScreen(screenId);
        return showService.addShowInScreen(movie, durationInMinutes, startTime, screen);
    }

    public List<String> getAvailableSeatsForShow(@NonNull final String showId) {

        Show show = showService.getShow(showId);
        List<Seat> seats = seatAvailabilityService.getAvailableSeats(show);
        return seats.stream()
                .map(Seat::getId)
                .toList();
    }
}
