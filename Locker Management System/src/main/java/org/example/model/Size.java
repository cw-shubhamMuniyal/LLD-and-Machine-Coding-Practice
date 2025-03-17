package org.example.model;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Size {

    private final Double width;
    private final Double height;

    public boolean canAccomodate(@NonNull final Size size) {
        return this.height >= size.height
                && this.width >= size.width;
    }
}
