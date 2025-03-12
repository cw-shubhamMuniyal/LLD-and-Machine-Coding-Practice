package org.example.io.output;

import org.example.model.player.Player;

import java.util.List;

public interface OutputProvider {

    void printMessage(String message);

    void printSelfBoard(Player player);

    void printWinner(Player player);

    void printOpponentBoard(List<Player> allPlayers, Player currentPlayer);
}
