package org.example.service.strategies;

import org.example.model.Location;

public class DistanceBasedPricingStrategy implements PricingStrategy {

    @Override
    public Double computePrice(Location source, Location destination) {
        return source.computeDistance(destination);
    }
}
