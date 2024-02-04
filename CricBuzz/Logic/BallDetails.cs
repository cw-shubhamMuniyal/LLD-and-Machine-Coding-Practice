using CricBuzz.Logic.Interfaces;
using CricBuzz.Model;

namespace CricBuzz.Logic
{
    public class BallDetails
    {
        public int Number;
        public BallType Type;
        public RunType runType;
        public PlayerDetails PlayedBy;
        public PlayerDetails BowledBy;
        public Wicket wicket;
        List<IScoreUpdaterObserver> scoreUpdaterObserverList = new();

        public BallDetails(int Number)
        {
            this.Number = Number;
            scoreUpdaterObserverList.Add(new BowlingScoreUpdater());
            scoreUpdaterObserverList.Add(new BattingScoreUpdater());
        }

        public void StartBallDelivery(Team battingTeam, Team bowlingTeam, OverDetails over)
        {
            PlayedBy = battingTeam.GetStriker();
            this.BowledBy = over.bowledBy;
            //THROW BALL AND GET THE BALL TYPE, assuming here that ball type is always NORMAL
            Type = BallType.Normal;

            //wicket or no wicket
            if (IsWicketTaken())
            {
                runType = RunType.Zero;
                //considering only BOLD
                wicket = new Wicket(WicketType.Bold, bowlingTeam.GetCurrentBowler(), over, this);
                //making only striker out for now
                battingTeam.SetStriker(null);
            }
            else
            {
                runType = GetRunType();
                if (runType == RunType.One || runType == RunType.Three)
                {
                    //swap striket and non striker
                    PlayerDetails temp = battingTeam.GetStriker();
                    battingTeam.SetStriker(battingTeam.GetNonStriker());
                    battingTeam.SetNonStriker(temp);
                }
            }
            //update player scoreboard
            NotifyUpdaters(this);
        }

        private void NotifyUpdaters(BallDetails ballDetails)
        {
            foreach (IScoreUpdaterObserver observer in scoreUpdaterObserverList)
            {
                observer.Update(ballDetails);
            }
        }

        private RunType GetRunType()
        {
            Random random = new();
            double val = random.NextDouble();
            if (val <= 0.2)
            {
                return RunType.One;
            }
            else if (val > 0.2 && val <= 0.5)
            {
                return RunType.Two;
            }
            else if (val > 0.5 && val <= 0.8)
            {
                return RunType.Four;
            }
            else
            {
                return RunType.Six;
            }
        }

        private bool IsWicketTaken()
        {
            //random function return value between 0 and 1
            Random random = new();
            double val = random.NextDouble();
            if (val < 0.2)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

    }
}