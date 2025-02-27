using System;

namespace ATM.ATMStates
{
    public class IdleState : ATMState
    {
        public override void InsertCard(Atm atm, Card card)
        {
            Console.WriteLine("Card is inserted");
            atm.SetCurrentATMState(new HasCardState());
        }
    }
}
