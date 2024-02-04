using CricBuzz.Model;

public class BattingManager
{
    Queue<PlayerDetails> yetToPlay;
    public PlayerDetails striker { get; set; }
    public PlayerDetails nonStriker { get; set; }

    public BattingManager(Queue<PlayerDetails> playing11)
    {
        this.yetToPlay = new();
        this.yetToPlay = new Queue<PlayerDetails>(playing11);
    }

    public void GetNextPlayer()
    {
        if (yetToPlay.Count == 0)
        {
            throw new Exception();
        }

        if (striker == null)
        {
            striker = yetToPlay.Dequeue();
        }

        if (nonStriker == null)
        {
            nonStriker = yetToPlay.Dequeue();
        }
    }
}