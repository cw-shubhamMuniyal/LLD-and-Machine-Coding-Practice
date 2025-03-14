package org.example.strategies;

import org.example.model.player.Player;

import java.util.List;

public interface WinningStrategy {

    Player getWinner(List<Player> players);
}
