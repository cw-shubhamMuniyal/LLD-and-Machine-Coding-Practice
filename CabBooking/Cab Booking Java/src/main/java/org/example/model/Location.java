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
                Math.pow(location.xCoordinate - this.xCoordinate, 2) +
                        Math.pow(location.yCoordinate - this.yCoordinate, 2)
        );
    }
}
