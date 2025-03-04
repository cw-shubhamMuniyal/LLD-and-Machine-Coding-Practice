package org.example.service.strategies;

import org.example.model.Location;

public interface PricingStrategy {

    Double computePrice(Location source, Location destination);
}
