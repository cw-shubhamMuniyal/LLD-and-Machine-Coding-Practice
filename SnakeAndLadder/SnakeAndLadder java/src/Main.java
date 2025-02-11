import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Snake and Ladder LLD!");
        System.out.println("____________________");

        Game game = new Game();
        game.initalizeGame();
        game.startGame();
    }
}