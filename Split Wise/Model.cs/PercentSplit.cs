namespace Model
{
    public class PercentSplit : Split
    {
        public PercentSplit(User user, double percent) : base(user)
        {
            this.Percent = percent;
        }
        public double Percent {get; set;}
    }
}