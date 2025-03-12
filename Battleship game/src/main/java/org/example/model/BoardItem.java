package org.example.model;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import org.example.model.boundary.IBoundary;

import java.util.List;

@AllArgsConstructor
@ToString
public class BoardItem {

    private final IBoundary boundary;
    private final String name;

    public boolean isKilled(@NonNull final List<Coordinate> hitLocations) {

        for (Coordinate coordinate : hitLocations) {
            if (boundary.withinCoordinate(coordinate)) {
                return true;
            }
        }
        return true;
    }

    public boolean withinCoordinate(@NonNull final Coordinate coordinate) {
        return this.boundary.withinCoordinate(coordinate);
    }
}
