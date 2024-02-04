using CricBuzz.Logic;
using CricBuzz.Logic.Interfaces;
using CricBuzz.Model;

public class InningDetails
{
    Team battingTeam;
    Team bowlingTeam;
    IMatchType _matchType;
    List<OverDetails> overs;

    public InningDetails(Team battingTeam, Team bowlingTeam, IMatchType matchType)
    {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this._matchType = matchType;
        overs = new();
    }

    public void Start(int runsToWin)
    {

        //set batting players
        try
        {
            battingTeam.ChooseNextBatsMan();
        }
        catch (Exception e)
        {

        }

        int noOfOvers = _matchType.NoOfOvers();
        for (int overNumber = 1; overNumber <= noOfOvers; overNumber++)
        {

            //chooseBowler
            bowlingTeam.ChooseNextBowler(_matchType.MaxOverCountBowlers());

            OverDetails over = new OverDetails(overNumber, bowlingTeam.GetCurrentBowler());
            overs.Add(over);
            try
            {
                bool won = over.StartOver(battingTeam, bowlingTeam, runsToWin);
                if (won == true)
                {
                    break;
                }
            }
            catch (Exception e)
            {
                break;
            }

            //swap striket and non striker
            PlayerDetails temp = battingTeam.GetStriker();
            battingTeam.SetStriker(battingTeam.GetNonStriker());
            battingTeam.SetNonStriker(temp);
        }
    }

    public int getTotalRuns()
    {
        return battingTeam.GetTotalRuns();
    }
}