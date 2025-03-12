package org.example.model.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.example.model.Board;
import org.example.model.Coordinate;
import org.example.model.PlayerChanceTarget;
import org.example.strategies.IChanceGenerationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class Player {

    private final Board board;
    private final Integer id;
    private final IChanceGenerationStrategy chanceGenerationStrategy;

    public PlayerChanceTarget takeChance(@NonNull final List<Player> players) {

        List<Player> opponents = new ArrayList<>();
        for (Player player : players) {
            if (!Objects.equals(player.id, this.id)) {
                opponents.add(player);
            }
        }
        return chanceGenerationStrategy.getPlayerChanceTarget(opponents);
    }

    public void hitTarget(@NonNull final Coordinate coordinate) {
        board.takeHit(coordinate);
    }

    public boolean hasPlayerLostGame() {
        return board.areAllShipsSunk();
    }
}
