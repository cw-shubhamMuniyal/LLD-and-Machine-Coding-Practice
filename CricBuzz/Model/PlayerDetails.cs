namespace CricBuzz.Model
{
    public class PlayerDetails
    {
        public Person Person;
        public PlayerType Type;
        public BattingScoreCard BattingScoreCard;
        public BowlingScoreCard BowlingScoreCard;

        public PlayerDetails(Person person, PlayerType playerType)
        {
            this.Person = person;
            this.Type = playerType;
            BattingScoreCard = new BattingScoreCard();
            BowlingScoreCard = new BowlingScoreCard();
        }

        public void PrintBattingScoreCard()
        {

            Console.WriteLine("PlayerName: " + Person.Name + " -- totalRuns: " + BattingScoreCard.TotalRuns
                    + " -- totalBallsPlayed: " + BattingScoreCard.TotalBallsPlayed + " -- 4s: " + BattingScoreCard.TotalFours
                    + " -- 6s: " + BattingScoreCard.TotalSixes
                    + " -- outby: " + ((BattingScoreCard.WicketDetails != null) ? BattingScoreCard.WicketDetails.TakenBy.Person.Name : "notout"));
        }

        public void PrintBowlingScoreCard()
        {
            Console.WriteLine("PlayerName: " + Person.Name + " -- totalOversThrown: " + BowlingScoreCard.TotalOversCount
                    + " -- totalRunsGiven: " + BowlingScoreCard.RunsGiven + " -- WicketsTaken: " + BowlingScoreCard.WicketsTaken);
        }
    }
}