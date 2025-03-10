package org.example.model;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Theater {

    private final String id;
    private final String name;
    private final List<Screen> screens;

    public Theater(@NonNull final String id, @NonNull final String name) {

        this.id = id;
        this.name = name;
        screens = new ArrayList<>();
    }

    public void addScreen(@NonNull final Screen screen) {
        screens.add(screen);
    }
}
