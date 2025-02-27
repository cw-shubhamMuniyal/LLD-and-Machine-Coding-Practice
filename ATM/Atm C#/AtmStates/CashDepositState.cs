using ATM;
using ATM.AmountDeposit;
using ATM.ATMStates;

public class CashDepositState : ATMState
{
    public override void CashDeposit(Atm atm, Card card, int depositAmount)
    {
        CardDepositProcessor cardDepositProcessor = new TwoThousandDepositProcessor(new FiveHundredWithdrawProcessor
        (new HundredDepositProcessor(null)));
        card.DepositAmount(4800);
        atm.AddAmount(4800);
        cardDepositProcessor.Deposit(atm, depositAmount);
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