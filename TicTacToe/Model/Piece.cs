namespace Model
{
    public class Piece
    {
        public PieceType Type { get; set; }
        public Piece(PieceType type)
        {
            this.Type = type;
        }
    }
}

