using CLI = CricBuzz.Logic.Interfaces;

namespace CricBuzz.Logic
{
    public class OneDayIMatch : CLI.IMatchType
    {
        public int NoOfOvers()
        {
            return 50;
        }

        public int MaxOverCountBowlers()
        {
            return 10;
        }
    }
}
