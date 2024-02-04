using CricBuzz.Model;

public class BowlingManager
{
    LinkedList<PlayerDetails> BowlersList;
    Dictionary<PlayerDetails, int> BowlerVsOverCount;
    public PlayerDetails currentBowler { get; private set; }

    public BowlingManager(List<PlayerDetails> bowlers)
    {
        SetBowlersList(bowlers);
    }

    private void SetBowlersList(List<PlayerDetails> BowlersList)
    {
        this.BowlersList = new();
        BowlerVsOverCount = new();
        foreach (PlayerDetails bowler in BowlersList)
        {
            this.BowlersList.AddLast(bowler);
            BowlerVsOverCount.Add(bowler, 0);
        }
    }

    public void GetNextBowler(int maxOverCountPerBowler)
    {
        PlayerDetails playerDetails = BowlersList.Last.Value;
        BowlersList.RemoveLast();
        if (BowlerVsOverCount.GetValueOrDefault(playerDetails) + 1 == maxOverCountPerBowler)
        {
            currentBowler = playerDetails;
        }
        else if(BowlerVsOverCount.GetValueOrDefault(playerDetails) + 1 < maxOverCountPerBowler)
        {
            currentBowler = playerDetails;
            BowlersList.AddLast(playerDetails);
            int value = BowlerVsOverCount.GetValueOrDefault(playerDetails) + 1;
            BowlerVsOverCount.Remove(playerDetails);
            BowlerVsOverCount.TryAdd(playerDetails, value);
        }
    }
}