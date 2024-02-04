using CricBuzz.Logic;

namespace CricBuzz.Model
{
    public class Wicket
    {
        public WicketType WicketType { get; }
        public PlayerDetails TakenBy { get; }
        public OverDetails OverDetail { get; }
        public BallDetails BallDetail { get; }

        public Wicket(WicketType wicketType, PlayerDetails takenBy, OverDetails overDetail, BallDetails ballDetail)
        {
            this.WicketType = wicketType;
            this.TakenBy = takenBy;
            this.OverDetail = overDetail;
            this.BallDetail = ballDetail;
        }
    }
}