import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Deque<Player> players;
    Board board;
    int size;
    BufferedReader bufferedReader;
    int[] rows;
    int[] columns;
    int diagonal = 0, reverseDiagonal = 0, movesPlayerd = 0;

    Game(int size) {
        players = new LinkedList<>();
        players.addFirst(new Player("player2", PieceType.O));
        players.addFirst(new Player("player1", PieceType.X));
        board = new Board(size);
        this.size = size;
        rows = new int[size];
        columns = new int[size];
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void playMove() throws IOException {

        while (true) {

            Player currentPlayer = players.getFirst();
            String playerName = currentPlayer.getName();
            PieceType playerPiece = currentPlayer.getPieceType();
            players.addLast(players.removeFirst());
            System.out.println(currentPlayer.getName() + "(" + playerPiece + ")" + ", Please enter your position]!");

            String[] input = bufferedReader.readLine().split(" ");

            int rowIndex = Integer.parseInt(input[0]);
            int colIndex = Integer.parseInt(input[1]);

            try {
                board.addPiece(rowIndex, colIndex, playerPiece);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                players.addFirst(players.removeLast());
                continue;
            }

            movesPlayerd++;
            if (playerName.equals("player1")) {
                rows[rowIndex]++;
                columns[colIndex]++;

                if (rowIndex == colIndex) {
                    diagonal++;
                }
                if (rowIndex + colIndex == size - 1) {
                    reverseDiagonal++;
                }

            } else {
                rows[rowIndex]--;
                columns[colIndex]--;

                if (rowIndex == colIndex) {
                    diagonal--;
                }
                if (rowIndex + colIndex == size - 1) {
                    reverseDiagonal--;
                }
            }

            board.printBoard();

            if (
                    Math.abs(rows[rowIndex]) == size
                            || Math.abs(columns[colIndex]) == size
                            || Math.abs(diagonal) == size
                            || Math.abs(reverseDiagonal) == size
            ) {
                System.out.println(playerName + " won!! Let's Start new game.");
                return;
            }

            if (movesPlayerd == size*size) {
                System.out.println("Game ended in a TIE! Let's Start new game.");
                return;
            }

        }
    }
}
