namespace ATM.AmountDeposit
{
    public abstract class CardDepositProcessor
    {
        protected CardDepositProcessor nextCashDepositProcessor;

        protected CardDepositProcessor(CardDepositProcessor cardDepositProcessor)
        {
            this.nextCashDepositProcessor = cardDepositProcessor;
        }

        public virtual void Deposit(Atm atm, int remainingAmount)
        {
            if (nextCashDepositProcessor != null)
            {
                nextCashDepositProcessor.Deposit(atm, remainingAmount);
            }
        }
    }
}