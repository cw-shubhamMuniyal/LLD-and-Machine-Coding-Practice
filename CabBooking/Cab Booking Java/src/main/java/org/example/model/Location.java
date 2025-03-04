package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Location {

    private final Double xCoordinate;
    private final Double yCoordinate;

    public Double computeDistance(Location location) {
        return Math.sqrt(
                Math.pow(location.xCoordinate, 2) - Math.pow(this.xCoordinate, 2) +
                        Math.pow(location.yCoordinate, 2) - Math.pow(this.yCoordinate, 2)
        );
    }
}
