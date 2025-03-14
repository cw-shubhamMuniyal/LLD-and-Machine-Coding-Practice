package org.example;

import org.example.io.input.SystemInputProvider;
import org.example.io.output.SystemOutputProvider;
import org.example.model.Board;
import org.example.model.BoardItem;
import org.example.model.Coordinate;
import org.example.model.boundary.IBoundary;
import org.example.model.boundary.RectangleBoundary;
import org.example.model.player.Player;
import org.example.strategies.*;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        System.out.println("Practicing battleship game!");

        final IChanceGenerationStrategy chanceGenerationStrategy = new LocalInputChanceGenerationStrategy(
                new SystemInputProvider()
        );

        IBoundary board1Boundary = new RectangleBoundary(
                new Coordinate(0,0),
                new Coordinate(100, 100)
        );

        IBoundary ship1Boundary = new RectangleBoundary(
                new Coordinate(10,10),
                new Coordinate(20, 20)
        );

        IBoundary ship2Boundary = new RectangleBoundary(
                new Coordinate(30,30),
                new Coordinate(50, 50)
        );

        BoardItem boardItem1 = new BoardItem(ship1Boundary, "Titanic");
        BoardItem boardItem2 = new BoardItem(ship2Boundary, "INS Rana");

        Board board1 = new Board (List.of(boardItem1, boardItem2), board1Boundary);
        Player player1 = new Player(board1, 1, chanceGenerationStrategy);

        IBoundary board2Boundary = new RectangleBoundary(
                new Coordinate(150,150),
                new Coordinate(250, 250)
        );

        IBoundary ship3Boundary = new RectangleBoundary(
                new Coordinate(160,180),
                new Coordinate(190, 200)
        );

        IBoundary ship4Boundary = new RectangleBoundary(
                new Coordinate(210,220),
                new Coordinate(220, 240)
        );

        BoardItem boardItem3 = new BoardItem(ship3Boundary, "INS Rajput");
        BoardItem boardItem4 = new BoardItem(ship4Boundary, "INS Taragiri");

        Board board2 = new Board (List.of(boardItem3, boardItem4), board2Boundary);
        Player player2 = new Player(board2, 2, chanceGenerationStrategy);

        List<Player> players = new ArrayList<>(List.of(player1, player2));

        PlayerPickingStrategy playerPickingStrategy = new RoundRobinPlayerPickingStrategy();
        WinningStrategy winningStrategy = new DefaultWinningStrategy();

        GameLoop gameLoop = new GameLoop(players,
                playerPickingStrategy,
                winningStrategy,
                new SystemOutputProvider());

        gameLoop.start();
    }
}