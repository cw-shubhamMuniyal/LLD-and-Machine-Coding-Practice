namespace ATM.Model
{
    public class UserBankAccount
    {
        public int Balance { get; private set; }

        public void WithdrawalBalance(int amount)
        {
            Balance -= amount;
        }
        public void AddAmount(int amount)
        {
            this.Balance += amount;
        }
    }
}
