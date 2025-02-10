import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Let's play Tic Tac Toe!");
        System.out.println("_______________________");

//        here, game board size can be customized. Kept it 3 for testing.
        Game game = new Game(3);
        game.playMove();
    }
}