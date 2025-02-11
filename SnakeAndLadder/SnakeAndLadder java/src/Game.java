import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Board board;
    Deque<Player> players;
    BufferedReader bufferedReader;
    Dice dice;
    int size;

    Game() {

//      customizable, this can be passed from input
        size = 50;
        board = new Board(50);
        players = new LinkedList<>();
        bufferedReader = new BufferedReader(new InputStreamReader((System.in)));
        dice = new Dice(2);
    }

    public void initalizeGame() {

        players.add(new Player("player1", 0));
        players.add(new Player("player2", 0));
        players.add(new Player("player3", 0));

//        customizable, snakes and  adding ladders at random positions
        board.addJump(10,
                new Snake(
                        JumpType.DOWN,
                        10,
                        6
                )
        );

        board.addJump(30,
                new Snake(
                        JumpType.DOWN,
                        30,
                        9
                )
        );

        board.addJump(41,
                new Snake(
                        JumpType.DOWN,
                        41,
                        24
                )
        );

        board.addJump(2,
                new Ladder(
                        JumpType.UP,
                        2,
                        15
                )
        );

        board.addJump(19,
                new Ladder(
                        JumpType.UP,
                        19,
                        32
                )
        );

        board.addJump(25,
                new Ladder(
                        JumpType.UP,
                        25,
                        38
                )
        );

    }

    public void startGame() throws IOException {

//        Playing till more than 1 players are playing
        while (players.size() > 1) {

            Player currentPlayer = players.removeFirst();
            players.addLast(currentPlayer);

            System.out.println(currentPlayer.getId() + ", press Enter to roll a dice");
            bufferedReader.readLine();

            int diceValue = dice.rollDice();
            System.out.println("Dice value " + diceValue);

            if (currentPlayer.getCurrentPosition() + diceValue <= size) {

                int currentPosition = getJumpUpdatedPosition(currentPlayer.getCurrentPosition() + diceValue);
                System.out.println("Current position of " + currentPlayer.getId() + " is " + currentPosition);
                System.out.println();

                if (currentPosition == size) {
                    System.out.println(currentPlayer.getId() + " WON!");
                    System.out.println("Removing " + currentPlayer.getId() + " from game!");
                    players.removeLast();
                } else if (currentPosition < size) {
                    currentPlayer.setCurrentPosition(currentPosition);
                } else {
                    continue;
                }
            }
            else {
                System.out.println(currentPlayer.getId() + " player will not move as dice value greater than required to win!");
            }
        }

        System.out.println(players.getFirst().getId() + " Better luck next time!");
        System.out.println("GAME OVER!!");
    }

    private int getJumpUpdatedPosition(int currentPosition) {

        Cell[] cells = board.getCells();
        if (currentPosition < size && cells[currentPosition] != null) {

            Jump jump = cells[currentPosition].getJump();
            if (jump != null && jump.getStartPosition() == currentPosition) {
                System.out.println("Payer will go " + jump.getType());
                return jump.getEndPosition();
            }
        }

        return currentPosition;
    }

}
