namespace Model
{
    public class Player
    {
        public Player(string name, Piece piece)
        {
            this.Name = name;
            this.Piece = piece;
        }
        public string Name {get; set;}
        public Piece Piece {get; set;}
    }
}

