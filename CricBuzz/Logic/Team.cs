using CricBuzz.Model;

public class Team
{
    public string teamName { get; private set; }
    Queue<PlayerDetails> playing11;
    List<PlayerDetails> bench;
    BattingManager _battingManager;
    BowlingManager _bowlingManager;
    public bool isWinner { get; set; }

    public Team(string teamName, Queue<PlayerDetails> playing11, List<PlayerDetails> bench, List<PlayerDetails> bowlers)
    {
        this.teamName = teamName;
        this.playing11 = playing11;
        this.bench = bench;
        _battingManager = new BattingManager(playing11);
        _bowlingManager = new BowlingManager(bowlers);
    }

    public void ChooseNextBatsMan()
    {
        _battingManager.GetNextPlayer();
    }

    public void ChooseNextBowler(int maxOverCountPerBowler)
    {
        _bowlingManager.GetNextBowler(maxOverCountPerBowler);
    }

    public PlayerDetails GetStriker()
    {
        return _battingManager.striker;
    }

    public PlayerDetails GetNonStriker()
    {
        return _battingManager.nonStriker;
    }

    public void SetStriker(PlayerDetails player)
    {
        _battingManager.striker = player;
    }

    public void SetNonStriker(PlayerDetails player)
    {
        _battingManager.nonStriker = player;
    }

    public PlayerDetails GetCurrentBowler()
    {
        return _bowlingManager.currentBowler;
    }

    public void PrintBattingScoreCard()
    {
        foreach (PlayerDetails playerDetails in playing11)
        {
            playerDetails.PrintBattingScoreCard();
        }
    }

    public void PrintBowlingScoreCard()
    {
        foreach (PlayerDetails playerDetails in playing11)
        {
            if (playerDetails.BowlingScoreCard.TotalOversCount > 0)
            {
                playerDetails.PrintBowlingScoreCard();
            }
        }
    }

    public int GetTotalRuns()
    {
        int totalRun = 0;
        foreach (PlayerDetails player in playing11)
        {
            totalRun += player.BattingScoreCard.TotalRuns;
        }
        return totalRun;
    }
}