package org.example.io.output;

import lombok.NonNull;
import org.example.model.player.Player;

import java.util.List;

public class SystemOutputProvider implements OutputProvider{

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printSelfBoard(Player player) {
        printMessage("Your board status: ");
        printPlayerInfo(player);
        printMessage("Board boundary: " + player.getBoard().getBoundary());
        printMessage("Ships: " + player.getBoard().getShips());
        printMessage("Hit locations: " + player.getBoard().fetchHitLocations());
        printMessage("Missed locations: " + player.getBoard().fetchMissLocations());
    }

    private void printPlayerInfo(@NonNull final Player player) {
        printMessage("Player " + player.getId());
    }

    private void printOpponentBoard(@NonNull final Player player) {
        printMessage("\nOpponent board status: ");
        printPlayerInfo(player);
        printMessage("Board boundary: " + player.getBoard().getBoundary());
        printMessage("Hit locations: " + player.getBoard().fetchHitLocations());
        printMessage("Missed locations: " + player.getBoard().fetchMissLocations());
    }

    @Override
    public void printWinner(Player player) {
        printMessage("Game Over!");
        printMessage("Player " + player.getId() + " has won!");
    }



    @Override
    public void printOpponentBoard(List<Player> allPlayers, Player currentPlayer) {
        for (Player player : allPlayers) {
            if (!player.getId().equals(currentPlayer.getId())) {
                printOpponentBoard(player);
            }
        }
    }
}
