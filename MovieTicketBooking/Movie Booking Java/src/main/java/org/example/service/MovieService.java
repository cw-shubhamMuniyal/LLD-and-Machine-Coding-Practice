package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.exceptions.NotFoundException;
import org.example.model.Movie;

import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
public class MovieService {

    private final Map<String, Movie> movies;

    public Movie addMovie(@NonNull final String name) {

        String id = UUID.randomUUID().toString();
        Movie movie = new Movie(id, name);
        movies.put(id, movie);
        return movie;
    }

    public Movie getMovie(@NonNull final String id) {

        if (!movies.containsKey(id)) {
            throw new NotFoundException();
        }
        return this.movies.get(id);
    }

}
