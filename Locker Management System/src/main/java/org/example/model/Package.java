package org.example.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Package implements LockerItem {

    private final String id;
    private final Size size;

    @Override
    public Size getSize() {
        return null;
    }
}
