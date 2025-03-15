package org.example.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Size {

    private final Double width;
    private final Double height;

    public boolean canAccomodate(Size size) {
        return this.height >= size.height
                && this.width >= size.width;
    }
}
