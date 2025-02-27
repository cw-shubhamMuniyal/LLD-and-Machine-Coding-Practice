namespace ATM.ATMStates
{
    public class CheckBalanceState : ATMState
    {
        public CheckBalanceState()
        {
        }

        public override void DisplayBalance(Atm atm, Card card)
        {
            Console.WriteLine("Your Balance is: " + card.GetBankBalance());
            Exit(atm);
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
