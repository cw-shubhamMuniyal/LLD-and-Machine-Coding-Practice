namespace Model
{
    public class Board
    {
        public Piece[][] PlayingBoard { get; set; }
        public int Capacity { get; set; }
        public Board(int capacity)
        {
            this.Capacity = capacity;
            this.PlayingBoard = new Piece[capacity][];
        }
        public bool IsBoardFilled()
        {
            for(int i=0;i<PlayingBoard.Length;i++)
            {
                for(int j=0;j<PlayingBoard[i].Length;j++)
                {
                    if(PlayingBoard[i][j] == null)
                    {
                        return false;
                    }
                }
            }
            return true;
        }
        public void AddPiece(int row, int col, Piece piece)
        {
            PlayingBoard[row][col] = piece;
        }
        public void PrintBoard()
        {
            for(int i=0;i<PlayingBoard.Length;i++)
            {
                for(int j=0;j<PlayingBoard[i].Length;j++)
                {
                    Piece piece = PlayingBoard[i][j];
                    Console.Write((piece == null ? " " : piece.Type.ToString()) +"   |   ");
                }
                Console.Write("\n");
                Console.Write("\n");

            }
        }
    }
}

