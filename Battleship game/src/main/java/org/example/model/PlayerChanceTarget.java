package org.example.model;

import lombok.AllArgsConstructor;
import org.example.model.player.Player;

@AllArgsConstructor
public class PlayerChanceTarget {

    private final Player player;
    private final Coordinate coordinate;
}
