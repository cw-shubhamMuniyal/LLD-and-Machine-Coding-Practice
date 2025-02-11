namespace Model
{
    public class Board
    {
        public Board(int capacity)
        {
            this.Capacity = capacity;
            this.Dice = new Dice();
        }
        public List<Snake> Snakes { get; } = new List<Snake>();
        public List<Ladder> Ladders { get; } = new List<Ladder>();
        public List<Player> Players { get; } = new();
        public int Capacity { get; set; }
        public Dice Dice { get; set; }
        public void AddSnake(int start, int end)
        {
            this.Snakes.Add(new Snake(start, end));
        }
        public void AddLadder(int start, int end)
        {
            this.Ladders.Add(new Ladder(start, end));
        }
        public void AddPlayer(string name)
        {
            this.Players.Add(new Player(name));
        }
    }
}
