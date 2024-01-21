namespace ATM.AmountWithdrawal
{
    public class TwoThousandWithdrawProcessor : CashWithdrawProcessor
    {
        public TwoThousandWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) : base(nextCashWithdrawProcessor)
        {
        }

        public override void Withdraw(Atm atm, int remainingAmount)
        {
            int required = remainingAmount / 2000;
            int balance = remainingAmount % 2000;

            if (required <= atm.GetNoOfTwoThousandNotes())
            {
                atm.DeductTwoThousandNotes(required);
            }
            else if (required > atm.GetNoOfTwoThousandNotes())
            {
                required =- atm.GetNoOfTwoThousandNotes();
                atm.DeductTwoThousandNotes(atm.GetNoOfTwoThousandNotes());
                balance = balance + required * 2000;
            }

            if (balance != 0)
            {
                base.Withdraw(atm, balance);
            }
        }
    }
}
