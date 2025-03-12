package org.example.strategies;

import lombok.AllArgsConstructor;
import org.example.exception.InvalidInputException;
import org.example.io.input.InputProvider;
import org.example.io.input.PlayerInput;
import org.example.model.Coordinate;
import org.example.model.PlayerChanceTarget;
import org.example.model.player.Player;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class LocalInputChanceGenerationStrategy implements IChanceGenerationStrategy {

    private final InputProvider inputProvider;

    @Override
    public PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents) {

        System.out.println("Enter target and its coordinates");
        PlayerInput player = inputProvider.takeInput();

        Player target = null;

        for (Player opponent : opponents) {
            if (opponent.getId().equals(player.getId())) {
                target = opponent;
            }
        }

        if (Objects.isNull(target)) {
            throw new InvalidInputException();
        }

        return new PlayerChanceTarget(
                target,
                new Coordinate(player.getTargetX(), player.getTargetY())
        );

    }
}
