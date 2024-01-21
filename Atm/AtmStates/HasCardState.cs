using System;

namespace ATM.ATMStates
{
    public class HasCardState : ATMState
    {
        public HasCardState()
        {
            Console.WriteLine("Enter your card PIN number");
        }

        public override void AuthenticatePin(Atm atm, Card card, int pin)
        {
            bool isCorrectPinEntered = card.IsCorrectPINEntered(pin);

            if (isCorrectPinEntered)
            {
                atm.SetCurrentATMState(new SelectOperationState());
            }
            else
            {
                Console.WriteLine("Invalid PIN Number");
                Exit(atm);
            }
        }

        public override void Exit(Atm atm)
        {
            ReturnCard();
            atm.SetCurrentATMState(new IdleState());
            Console.WriteLine("Exit happens");
        }

        public override void ReturnCard()
        {
            Console.WriteLine("Please collect your card");
        }
    }
}
