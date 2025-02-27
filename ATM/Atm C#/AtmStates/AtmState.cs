using ATM;

namespace ATM.ATMStates
{
    public abstract class ATMState
    {
        public virtual void InsertCard(Atm atm, Card card)
        {
            Console.WriteLine("OOPS!! Something went wrong");
        }

        public virtual void AuthenticatePin(Atm atm, Card card, int pin)
        {
            Console.WriteLine("OOPS!! Something went wrong");
        }

        public virtual void SelectOperation(Atm atm, Card card, TransactionType txnType)
        {
            Console.WriteLine("OOPS!! Something went wrong");
        }

        public virtual void CashWithdrawal(Atm atm, Card card, int withdrawAmount)
        {
            Console.WriteLine("OOPS!! Something went wrong");
        }

        public virtual void CashDeposit(Atm atm, Card card, int withdrawAmount)
        {
            Console.WriteLine("OOPS!! Something went wrong");
        }

        public virtual void DisplayBalance(Atm atm, Card card)
        {
            Console.WriteLine("OOPS!! Something went wrong");
        }

        public virtual void ReturnCard()
        {
            Console.WriteLine("OOPS!! Something went wrong");
        }

        public virtual void Exit(Atm atm)
        {
            Console.WriteLine("OOPS!! Something went wrong");
        }
    }
}
