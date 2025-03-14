package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import org.example.exception.CoordinateOutOfBoundaryException;
import org.example.model.boundary.IBoundary;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Board {

    private final List<BoardItem> ships;
    private final IBoundary boundary;
    private final List<Coordinate> bombLocations;

    public Board(List<BoardItem> ships,
                 IBoundary boundary) {

        this.ships = ships;
        this.boundary = boundary;
        this.bombLocations = new ArrayList<>();
    }

    public void takeHit(@NonNull final Coordinate coordinate) {

        if (!this.boundary.withinCoordinate(coordinate)) {
            throw new CoordinateOutOfBoundaryException();
        }
        this.bombLocations.add(coordinate);
    }

    public List<Coordinate> fetchHitLocations() {

        List<Coordinate> hitLocations = new ArrayList<>();
        for (Coordinate coordinate : bombLocations) {
            for (BoardItem boardItem : ships) {
                if (boardItem.withinCoordinate(coordinate)) {
                    hitLocations.add(coordinate);
                    break;
                }
            }
        }

        return hitLocations;
    }

    public List<Coordinate> fetchMissLocations() {

        List<Coordinate> missLocations = new ArrayList<>();
        boolean isShipAttacked = false;
        for (Coordinate coordinate : bombLocations) {
            for (BoardItem boardItem : ships) {
                if (boardItem.withinCoordinate(coordinate)) {
                    isShipAttacked = true;
                    break;
                }
            }

            if (!isShipAttacked) {
                missLocations.add(coordinate);
            }
        }

        return missLocations;
    }

    public boolean areAllShipsSunk() {

        for (BoardItem boardItem : ships) {

            if (!boardItem.isKilled(bombLocations)) {
                return false;
            }
        }
        return true;
    }
}
