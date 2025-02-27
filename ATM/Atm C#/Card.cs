using ATM.Model;

namespace ATM
{
    public class Card
    {
        private int cardNumber;
        private int cvv;
        private int expiryDate;
        private int holderName;
        private static int PIN_NUMBER = 112211;
        public UserBankAccount BankAccount;

        public bool IsCorrectPINEntered(int pin)
        {
            return pin == PIN_NUMBER;
        }

        public int GetBankBalance()
        {
            return BankAccount.Balance;
        }

        public void DeductBankBalance(int amount)
        {
            BankAccount.WithdrawalBalance(amount);
        }

        public void DepositAmount(int amount)
        {
            BankAccount.AddAmount(amount);
        }

        public void SetBankAccount(UserBankAccount bankAccount)
        {
            this.BankAccount = bankAccount;
        }
    }
}
