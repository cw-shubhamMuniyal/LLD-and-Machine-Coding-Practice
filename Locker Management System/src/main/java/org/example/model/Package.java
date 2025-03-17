package org.example.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Package implements LockerItem {

    private final String id;
    private final Size size;

    @Override
    public Size getSize() {
        return size;
    }
}
