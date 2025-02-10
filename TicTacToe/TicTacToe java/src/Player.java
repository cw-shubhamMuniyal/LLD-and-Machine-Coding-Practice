public class Player {

    private String name;
    private PieceType pieceType;

    public Player(String name, PieceType pieceType) {
        this.name = name;
        this.pieceType = pieceType;
    }

    public String getName() {
        return name;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
