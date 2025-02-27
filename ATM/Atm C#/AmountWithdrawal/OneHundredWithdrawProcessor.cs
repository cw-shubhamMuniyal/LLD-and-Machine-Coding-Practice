namespace ATM.AmountWithdrawal
{
    public class OneHundredWithdrawProcessor : CashWithdrawProcessor
    {
        public OneHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) : base(nextCashWithdrawProcessor)
        {
        }

        public override void Withdraw(Atm atm, int remainingAmount)
        {
            int required = remainingAmount / 100;
            int balance = remainingAmount % 100;

            if (required <= atm.GetNoOfOneHundredNotes())
            {
                atm.DeductOneHundredNotes(required);
            }
            else if (required > atm.GetNoOfOneHundredNotes())
            {
                required =- atm.GetNoOfOneHundredNotes();
                atm.DeductOneHundredNotes(atm.GetNoOfOneHundredNotes());
                balance = balance + required * 100;
            }

            if (balance != 0)
            {
                Console.WriteLine("Something went wrong");
            }
        }
    }
}
