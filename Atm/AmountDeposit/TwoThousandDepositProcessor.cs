namespace ATM.AmountDeposit
{
    public class TwoThousandDepositProcessor : CardDepositProcessor
    {
        public TwoThousandDepositProcessor(CardDepositProcessor nextCashWithdrawProcessor) : base(nextCashWithdrawProcessor)
        {
        }

        public override void Deposit(Atm atm, int remainingAmount)
        {
            int noOfNotes = remainingAmount / 2000;
            int balance = remainingAmount % 2000;

            if (noOfNotes >= 1)
            {
                atm.AddTwoThousandNotes(noOfNotes);
            }

            if (balance != 0)
            {
                base.Deposit(atm, balance);
            }
        }
    }
}
