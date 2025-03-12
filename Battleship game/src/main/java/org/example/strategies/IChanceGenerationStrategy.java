package org.example.strategies;

import org.example.model.PlayerChanceTarget;
import org.example.model.player.Player;

import java.util.List;

public interface IChanceGenerationStrategy {
    PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents);
}
