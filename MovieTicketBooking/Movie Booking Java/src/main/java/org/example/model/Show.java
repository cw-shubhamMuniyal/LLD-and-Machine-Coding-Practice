package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Show {

    private final String id;
    private final Screen screen;
    private final LocalDateTime startTime;
    private final Integer durationInMinutes;
    private final Movie movie;
}
