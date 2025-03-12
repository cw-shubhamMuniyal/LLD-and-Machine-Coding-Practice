package org.example.model.boundary;

import org.example.model.Coordinate;

import java.util.List;

public interface IBoundary {

    boolean withinCoordinate(Coordinate coordinate);
    List<Coordinate> getAllCoordinates();
}
