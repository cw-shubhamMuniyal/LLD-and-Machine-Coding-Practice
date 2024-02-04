using CricBuzz.Logic.Interfaces;

public class Match
{
    Team teamA;
    Team teamB;
    DateOnly matchDate;
    String venue;
    Team tossWinner;
    InningDetails[] innings;
    IMatchType _matchType;

    public Match(Team teamA, Team teamB, DateOnly matchDate, String venue, IMatchType matchType)
    {

        this.teamA = teamA;
        this.teamB = teamB;
        this.matchDate = matchDate;
        this.venue = venue;
        this._matchType = matchType;
        innings = new InningDetails[2];
    }

    public void startMatch()
    {

        //1. Toss
        tossWinner = toss(teamA, teamB);

        //start The Inning, there are 2 innings in a match
        for (int inning = 1; inning <= 2; inning++)
        {

            InningDetails inningDetails;
            Team bowlingTeam;
            Team battingTeam;

            //assuming here that tossWinner batFirst
            bool isChasing = false;
            if (inning == 1)
            {
                battingTeam = tossWinner;
                bowlingTeam = tossWinner.teamName.Equals(teamA.teamName) ? teamB : teamA;
                inningDetails = new InningDetails(battingTeam, bowlingTeam, _matchType);
                inningDetails.Start(-1);

            }
            else
            {
                bowlingTeam = tossWinner;
                battingTeam = tossWinner.teamName.Equals(teamA.teamName) ? teamB : teamA;
                inningDetails = new InningDetails(battingTeam, bowlingTeam, _matchType);
                inningDetails.Start(innings[0].getTotalRuns());
                if (bowlingTeam.GetTotalRuns() > battingTeam.GetTotalRuns())
                {
                    bowlingTeam.isWinner = true;
                }
            }


            innings[inning - 1] = inningDetails;

            //print inning details
            Console.WriteLine();
            Console.WriteLine("INNING " + inning + " -- total Run: " + battingTeam.GetTotalRuns());
            Console.WriteLine("---Batting ScoreCard : " + battingTeam.teamName + "---");

            battingTeam.PrintBattingScoreCard();

            Console.WriteLine();
            Console.WriteLine("---Bowling ScoreCard : " + bowlingTeam.teamName + "---");
            bowlingTeam.PrintBowlingScoreCard();

        }

        Console.WriteLine();
        if (teamA.isWinner)
        {
            Console.WriteLine("---WINNER---" + teamA.teamName);

        }
        else
        {
            Console.WriteLine("---WINNER---" + teamB.teamName);

        }
    }

    private Team toss(Team teamA, Team teamB)
    {
        //random function return value between 0 and 1
        Random random = new();
        double value = random.NextDouble();
        if (value < 0.5)
        {
            return teamA;
        }
        else
        {
            return teamB;
        }
    }
}