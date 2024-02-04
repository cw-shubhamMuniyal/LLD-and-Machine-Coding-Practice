using CLI = CricBuzz.Logic.Interfaces;

namespace CricBuzz.Logic
{
    public class T20Match : CLI.IMatchType
    {
        public int NoOfOvers()
        {
            return 20;
        }

        public int MaxOverCountBowlers()
        {
            return 5;
        }
    }
}
