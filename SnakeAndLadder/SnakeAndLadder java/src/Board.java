public class Board {

    private final Cell[] cells;

    Board(int size) {
        this.cells = new Cell[size];
    }

    public Cell[] getCells() {
        return cells;
    }

    void addJump(int position, Jump jump) {
        cells[position] = new Cell(jump);
    }
}
