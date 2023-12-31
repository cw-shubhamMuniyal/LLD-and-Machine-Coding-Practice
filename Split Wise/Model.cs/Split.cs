namespace Model
{
    public abstract class Split
    {
        public User User {get; set;}
        public double Amount {get; set;}
        public Split(User user)
        {
            this.User = user;
        }
        public void SetAmount(double amount)
        {
            this.Amount = amount;
        }
    }
}