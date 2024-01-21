namespace ATM.AmountDeposit
{
    public class HundredDepositProcessor : CardDepositProcessor
    {
        public HundredDepositProcessor(CardDepositProcessor nextCashWithdrawProcessor) : base(nextCashWithdrawProcessor)
        {
        }

        public override void Deposit(Atm atm, int remainingAmount)
        {
            int noOfNotes = remainingAmount / 100;
            int balance = remainingAmount % 100;

            if (noOfNotes >= 1)
            {
                atm.AddOneHundredNotes(noOfNotes);
            }

            if (balance != 0)
            {
                base.Deposit(atm, balance);
            }
        }
    }
}
