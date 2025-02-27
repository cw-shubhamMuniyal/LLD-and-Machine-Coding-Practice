// Took Code from YT which was in java language and converted to C# for my learning
using ATM.Model;

namespace ATM
{
    class ATMRoom
    {
        Atm Atm;
        User User;

        static void Main(string[] args)
        {
            ATMRoom atmRoom = new ATMRoom();
            atmRoom.Initialize();

            atmRoom.Atm.PrintCurrentATMStatus();
            atmRoom.Atm.GetCurrentATMState().InsertCard(atmRoom.Atm, atmRoom.User.Card);
            atmRoom.Atm.GetCurrentATMState().AuthenticatePin(atmRoom.Atm, atmRoom.User.Card, 112211);
            atmRoom.Atm.GetCurrentATMState().SelectOperation(atmRoom.Atm, atmRoom.User.Card, TransactionType.CASH_DEPOSIT);
            // atmRoom.Atm.GetCurrentATMState().CashWithdrawal(atmRoom.Atm, atmRoom.User.Card, 2700);
            atmRoom.Atm.GetCurrentATMState().CashDeposit(atmRoom.Atm, atmRoom.User.Card, 4800);
            atmRoom.Atm.PrintCurrentATMStatus();
        }

        private void Initialize()
        {
            // Create ATM
            Atm = Atm.GetATMObject();
            Atm.SetAtmBalance(3500, 1, 2, 5);

            // Create User
            User = CreateUser();
        }

        private User CreateUser()
        {
            User user = new User();
            user.Card = CreateCard();
            return user;
        }

        private Card CreateCard()
        {
            Card card = new Card();
            card.BankAccount = CreateBankAccount();
            return card;
        }

        private UserBankAccount CreateBankAccount()
        {
            UserBankAccount bankAccount = new UserBankAccount();
            bankAccount.AddAmount(3000);
            return bankAccount;
        }
    }
}
