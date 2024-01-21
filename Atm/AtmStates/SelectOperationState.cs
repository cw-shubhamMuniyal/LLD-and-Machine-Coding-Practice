namespace ATM.ATMStates
{
    public class SelectOperationState : ATMState
    {
        public SelectOperationState()
        {
            ShowOperations();
        }

        public override void SelectOperation(Atm atmObject, Card card, TransactionType txnType)
        {
            switch (txnType)
            {
                case TransactionType.CASH_WITHDRAWAL:
                    atmObject.SetCurrentATMState(new CashWithdrawalState());
                    break;
                case TransactionType.BALANCE_CHECK:
                    atmObject.SetCurrentATMState(new CheckBalanceState());
                    break;
                case TransactionType.CASH_DEPOSIT:
                    atmObject.SetCurrentATMState(new CashDepositState());
                    break;
                default:
                    Console.WriteLine("Invalid Option");
                    Exit(atmObject);
                    break;
            }
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

        private void ShowOperations()
        {
            Console.WriteLine("Please select the Operation");
            ShowAllTransactionTypes();
        }
        public static void ShowAllTransactionTypes()
        {
            foreach (TransactionType type in Enum.GetValues(typeof(TransactionType)))
            {
                Console.WriteLine(type.ToString());
            }
        }
    }
}
