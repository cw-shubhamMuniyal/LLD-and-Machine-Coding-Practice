package org.example.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.model.Movie;
import org.example.service.MovieService;

@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    public Movie addMovie(@NonNull final String name) {

        return movieService.addMovie(name);
    }

    public Movie getMovie(@NonNull final String id) {

        return movieService.getMovie(id);
    }
}
