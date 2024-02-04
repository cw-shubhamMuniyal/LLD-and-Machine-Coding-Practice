using CricBuzz.Logic;
using CricBuzz.Logic.Interfaces;
using CricBuzz.Model;

public class BowlingScoreUpdater : IScoreUpdaterObserver
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
        }
        else if (RunType.Six == ballDetails.runType)
        {
            run = 6;
        }
        if (ballDetails.Number == 6 && ballDetails.Type == BallType.Normal)
        {
            ballDetails.BowledBy.BowlingScoreCard.TotalOversCount++;
        }
        if (ballDetails.wicket != null)
        {
            ballDetails.BowledBy.BowlingScoreCard.WicketsTaken++;
        }
        if (ballDetails.Type == BallType.WideBall)
        {
            ballDetails.BowledBy.BowlingScoreCard.WideBallCount++;
            run = 1;
        }
        if (ballDetails.Type == BallType.NoBall)
        {
            ballDetails.BowledBy.BowlingScoreCard.NoBallCount++;
            run++;
        }
        ballDetails.BowledBy.BowlingScoreCard.RunsGiven += run;
    }
}