package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.model.player.Player;

@AllArgsConstructor
@Getter
public class PlayerChanceTarget {

    private final Player player;
    private final Coordinate coordinate;
}
