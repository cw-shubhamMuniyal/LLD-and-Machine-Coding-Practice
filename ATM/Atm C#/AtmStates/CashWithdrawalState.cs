using ATM.AmountWithdrawal;

namespace ATM.ATMStates
{
    public class CashWithdrawalState : ATMState
    {
        public CashWithdrawalState()
        {
            Console.WriteLine("Please enter the Withdrawal Amount");
        }

        public override void CashWithdrawal(Atm atmObject, Card card, int withdrawalAmountRequest)
        {
            if (atmObject.GetAtmBalance() < withdrawalAmountRequest)
            {
                Console.WriteLine("Insufficient funds in the ATM Machine");
            }
            else if (card.GetBankBalance() < withdrawalAmountRequest)
            {
                Console.WriteLine("Insufficient funds in your Bank Account");
            }
            else
            {
                card.DeductBankBalance(withdrawalAmountRequest);
                atmObject.DeductATMBalance(withdrawalAmountRequest);

                // Using chain of responsibility for this logic - how many 2k Rs notes, how many 500 Rs notes, etc., has to be withdrawn
                CashWithdrawProcessor withdrawProcessor =
                    new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));

                withdrawProcessor.Withdraw(atmObject, withdrawalAmountRequest);
            }
            Exit(atmObject);
        }

        public override void Exit(Atm atmObject)
        {
            ReturnCard();
            atmObject.SetCurrentATMState(new IdleState());
            Console.WriteLine("Exit happens");
        }

        public override void ReturnCard()
        {
            Console.WriteLine("Please collect your card");
        }
    }
}
