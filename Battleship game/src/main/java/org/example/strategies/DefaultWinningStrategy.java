package org.example.strategies;

import org.example.model.player.Player;

import java.util.List;

public class DefaultWinningStrategy implements WinningStrategy {

    @Override
    public Player getWinner(List<Player> players) {

        Integer numberOfAlivePlayers = 0;
        Player winner = null;

        for (Player player : players) {
            if (!player.getBoard().areAllShipsSunk()) {
                numberOfAlivePlayers ++;
                winner = player;
            }
        }

        if (numberOfAlivePlayers == 1) {
            return winner;
        }

        return null;
    }
}
