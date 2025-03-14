package org.example.strategies;

import org.example.exception.NoPlayerAvailableException;
import org.example.model.player.Player;

import java.util.List;
import java.util.Objects;

public class RoundRobinPlayerPickingStrategy implements PlayerPickingStrategy {

    @Override
    public Integer fetchFirstPlayer(List<Player> players) {

        if (Objects.isNull(players) || players.isEmpty()) {
            throw new NoPlayerAvailableException();
        }
        return 0;
    }

    @Override
    public Integer fetchNextPlayer(List<Player> players, Integer currentPlayerIndex) {

        if (Objects.isNull(players) || players.isEmpty()) {
            throw new NoPlayerAvailableException();
        }
        return  (currentPlayerIndex + 1) % players.size();
    }
}
