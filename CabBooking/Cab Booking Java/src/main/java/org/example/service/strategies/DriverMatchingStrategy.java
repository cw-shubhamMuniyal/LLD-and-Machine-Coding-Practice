package org.example.service.strategies;

import org.example.model.Driver;
import org.example.model.Location;

import java.util.List;

public interface DriverMatchingStrategy {

    public Driver fetchDriver(Location sourceLocation);
}
