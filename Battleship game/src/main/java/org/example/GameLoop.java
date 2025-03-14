package org.example;

import lombok.AllArgsConstructor;
import org.example.exception.CoordinateOutOfBoundaryException;
import org.example.exception.InvalidInputException;
import org.example.io.output.OutputProvider;
import org.example.model.PlayerChanceTarget;
import org.example.model.player.Player;
import org.example.strategies.PlayerPickingStrategy;
import org.example.strategies.WinningStrategy;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class GameLoop {

    private final List<Player> players;
    private final PlayerPickingStrategy playerPickingStrategy;
    private final WinningStrategy winningStrategy;
    private final OutputProvider outputProvider;

    void start() {

        outputProvider.printMessage("Starting Game!");
        Integer playerIndex = playerPickingStrategy.fetchFirstPlayer(players);

        while (true) {

            Player player = players.get(playerIndex);

            outputProvider.printMessage("Player " + player.getId() + " chance: ");

            PlayerChanceTarget playerChanceTarget = null;
            try {
                playerChanceTarget = player.takeChance(players);
            } catch (InvalidInputException invalidInputException) {
                outputProvider.printMessage("Given player is not available!");
                continue;
            }

            Player targetPlayer = playerChanceTarget.getPlayer();

            try {
                targetPlayer.hitTarget(playerChanceTarget.getCoordinate());
            } catch (CoordinateOutOfBoundaryException coordinateOutOfBoundaryException) {
                outputProvider.printMessage("Target coordinate is out of opponent's boundary!");
                continue;
            }

            outputProvider.printSelfBoard(player);
            outputProvider.printOpponentBoard(players, player);

            if (targetPlayer.hasPlayerLostGame()) {

                players.remove(targetPlayer);
                Player winner = winningStrategy.getWinner(players);
                if (Objects.nonNull(winner)) {
                    outputProvider.printWinner(winner);
                    break;
                }
            }

            playerIndex = playerPickingStrategy.fetchNextPlayer(players, playerIndex);
        }
    }
}
