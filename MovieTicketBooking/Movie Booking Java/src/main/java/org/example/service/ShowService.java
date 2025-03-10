package org.example.service;

import lombok.NonNull;
import org.example.exceptions.NotFoundException;
import org.example.model.Movie;
import org.example.model.Screen;
import org.example.model.Show;

import java.time.LocalDateTime;
import java.util.*;

public class ShowService {

    Map<String, Show> shows = new HashMap<>();

    public Show addShowInScreen(@NonNull final Movie movie,
                                @NonNull final Integer durationInMinutes,
                                @NonNull final LocalDateTime startTime, Screen screen) {

        String id = UUID.randomUUID().toString();
        Show show = new Show(id, screen, startTime, durationInMinutes, movie);
        shows.put(id, show);
        return show;
    }

    public Show getShow(@NonNull final String showId) {

        if (!shows.containsKey(showId)) {
            throw  new NotFoundException();
        }

        return this.shows.get(showId);
    }

    public List<Show> getShowForScreen(@NonNull final Screen screen) {

        List<Show> response = new ArrayList<>();
        for (Show show : shows.values()) {

            if (show.getScreen().equals(screen)) {
                response.add(show);
            }
        }

        return response;
    }

}
