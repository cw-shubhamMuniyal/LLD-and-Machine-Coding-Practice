using CricBuzz.Logic;
using CricBuzz.Logic.Interfaces;
using CricBuzz.Model;

public class BattingScoreUpdater : IScoreUpdaterObserver
{
    public void Update(BallDetails ballDetails)
    {
        int run = 0;
        if (RunType.One == ballDetails.runType)
        {
            run = 1;
        }
        else if (RunType.Two == ballDetails.runType)
        {
            run = 2;
        }
        else if (RunType.Four == ballDetails.runType)
        {
            run = 4;
            ballDetails.PlayedBy.BattingScoreCard.TotalFours++;
        }
        else if (RunType.Six == ballDetails.runType)
        {
            run = 6;
            ballDetails.PlayedBy.BattingScoreCard.TotalSixes++;
        }
        ballDetails.PlayedBy.BattingScoreCard.TotalRuns += run;
        ballDetails.PlayedBy.BattingScoreCard.TotalBallsPlayed++;

        if (ballDetails.wicket != null)
        {
            ballDetails.PlayedBy.BattingScoreCard.WicketDetails = ballDetails.wicket;
        }
    }
}