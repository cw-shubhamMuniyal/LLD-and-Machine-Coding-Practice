namespace ATM.AmountWithdrawal
{
    public class FiveHundredWithdrawProcessor : CashWithdrawProcessor
    {
        public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) : base(nextCashWithdrawProcessor)
        {
        }

        public override void Withdraw(Atm atm, int remainingAmount)
        {
            int required = remainingAmount / 500;
            int balance = remainingAmount % 500;

            if (required <= atm.GetNoOfFiveHundredNotes())
            {
                atm.DeductFiveHundredNotes(required);
            }
            else if (required > atm.GetNoOfFiveHundredNotes())
            {
                required =- atm.GetNoOfFiveHundredNotes();
                atm.DeductFiveHundredNotes(atm.GetNoOfFiveHundredNotes());
                balance = balance + required * 500;
            }

            if (balance != 0)
            {
                base.Withdraw(atm, balance);
            }
        }
    }
}
