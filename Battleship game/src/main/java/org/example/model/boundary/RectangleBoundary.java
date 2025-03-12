package org.example.model.boundary;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.example.model.Coordinate;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ToString
public class RectangleBoundary implements IBoundary {

    Coordinate topLeftCoordinate;
    Coordinate bottomRightCoordinate;

    @Override
    public boolean withinCoordinate(Coordinate coordinate) {

        return coordinate.getX() >= this.topLeftCoordinate.getX()
                && coordinate.getX() <= this.bottomRightCoordinate.getX()
                && coordinate.getY() >= this.topLeftCoordinate.getY()
                && coordinate.getY() <= this.bottomRightCoordinate.getY();
    }

    @Override
    public List<Coordinate> getAllCoordinates() {

        List<Coordinate> coordinates = new ArrayList<>();

        for (int i = topLeftCoordinate.getX(); i < bottomRightCoordinate.getX(); i++) {
            for (int j = topLeftCoordinate.getY(); j < bottomRightCoordinate.getY(); j++) {
                coordinates.add(new Coordinate(i, j));
            }
        }

        return coordinates;
    }
}
