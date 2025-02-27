namespace ATM.AmountWithdrawal
{
    public abstract class CashWithdrawProcessor
    {
        protected CashWithdrawProcessor nextCashWithdrawalProcessor;

        protected CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor)
        {
            this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;
        }

        public virtual void Withdraw(Atm atm, int remainingAmount)
        {
            if (nextCashWithdrawalProcessor != null)
            {
                nextCashWithdrawalProcessor.Withdraw(atm, remainingAmount);
            }
        }
    }
}
