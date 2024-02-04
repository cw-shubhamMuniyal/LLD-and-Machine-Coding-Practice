namespace CricBuzz.Logic.Interfaces
{
    public interface IScoreUpdaterObserver
    {
        public void Update(BallDetails ballDetails);
    }
}