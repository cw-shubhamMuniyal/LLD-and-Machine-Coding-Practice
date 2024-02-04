using CricBuzz.Model;

namespace CricBuzz.Logic
{
    public class OverDetails
    {
        int overNumber;
        List<BallDetails> balls;
        int extraBallsCount;
        public PlayerDetails bowledBy { get; }

        public OverDetails(int overNumber, PlayerDetails bowledBy)
        {
            this.overNumber = overNumber;
            balls = new();
            this.bowledBy = bowledBy;
        }

        public bool StartOver(Team battingTeam, Team bowlingTeam, int runsToWin)
        {
            int ballCount = 1;
            while (ballCount <= 6)
            {
                BallDetails ball = new BallDetails(ballCount);
                ball.StartBallDelivery(battingTeam, bowlingTeam, this);
                if (ball.Type == BallType.Normal)
                {
                    balls.Add(ball);
                    ballCount++;
                    if (ball.wicket != null)
                    {
                        battingTeam.ChooseNextBatsMan();
                    }
                    if (runsToWin != -1 && battingTeam.GetTotalRuns() >= runsToWin)
                    {
                        battingTeam.isWinner = true;
                        return true;
                    }
                }
                else
                {
                    extraBallsCount++;
                }
            }
            return false;
        }
    }
}