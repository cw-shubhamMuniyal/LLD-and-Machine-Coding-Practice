package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Ride {

    private String riderId;
    @Getter
    private String driverId;
    private Location source;
    private Location destination;
    private Double price;

    public void updatePrice(Double price) {
        this.price = price;
    }
}
