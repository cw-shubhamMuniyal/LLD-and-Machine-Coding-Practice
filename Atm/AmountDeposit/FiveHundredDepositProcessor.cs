namespace ATM.AmountDeposit
{
    public class FiveHundredWithdrawProcessor : CardDepositProcessor
    {
        public FiveHundredWithdrawProcessor(CardDepositProcessor nextCashWithdrawProcessor) : base(nextCashWithdrawProcessor)
        {
        }

        public override void Deposit(Atm atm, int remainingAmount)
        {
            int noOfNotes = remainingAmount / 500;
            int balance = remainingAmount % 500;

            if (noOfNotes >= 1)
            {
                atm.AddFiveHundredNotes(noOfNotes);
            }

            if (balance != 0)
            {
                base.Deposit(atm, balance);
            }
        }
    }
}
