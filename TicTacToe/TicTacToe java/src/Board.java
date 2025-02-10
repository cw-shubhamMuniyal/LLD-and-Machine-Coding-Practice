import java.util.Objects;

public class Board {

    PieceType[][] board;
    int size;

    Board(int size) {
        board = new PieceType[size][size];
        this.size = size;
    }

    public PieceType[][] getBoard() {
        return board;
    }

    void addPiece(int row, int column, PieceType pieceType) throws Exception {

        if (row < 0 || row > size || column < 0 || column > size) {
            throw new Exception("Board position is not valid, " +
                    "please enter correct board position to continue!");
        }

        if (Objects.nonNull(board[row][column])) {
            throw new Exception("this position is already occupied, " +
                    "please enter correct board position to continue!");
        }

        board[row][column] = pieceType;
    }

    void printBoard() {
        String peice;
        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                peice = board[i][j] != null ? board[i][j].name() : "";
                System.out.print(peice + "  |   ");
            }
            System.out.println();
        }
    }
}
