namespace Model
{
    public class Player
    {
        public string Name { get; set; }
        public int Position { get; set; }
        public PlayerStatus Status { get; set; }
        public Player(string name)
        {
            this.Name = name;
            Status = PlayerStatus.Playing;
        }
        public void ChangeStatus(PlayerStatus playerStatus)
        {
            this.Status = playerStatus;
        }
    }
}
