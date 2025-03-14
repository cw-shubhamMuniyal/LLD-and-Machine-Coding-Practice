package org.example.strategies;

import org.example.model.player.Player;

import java.util.List;

public interface PlayerPickingStrategy {

    Integer fetchFirstPlayer(List<Player> players);
    Integer fetchNextPlayer(List<Player> players, Integer currentPlayerIndex);
}
