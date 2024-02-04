namespace CricBuzz.Model
{
    public class BattingScoreCard
    {
        public int TotalRuns { get; set; }
        public int TotalBallsPlayed { get; set; }
        public int TotalFours { get; set; }
        public int TotalSixes { get; set; }
        public double StrikeRate { get; }
        public Wicket WicketDetails { get; set; }
    }
}