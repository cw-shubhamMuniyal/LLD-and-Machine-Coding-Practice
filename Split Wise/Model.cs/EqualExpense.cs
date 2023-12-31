
using Logic;

namespace Model
{
    public class EqualExpense : Expense
    {
        public EqualExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata)
            : base(amount, paidBy, splits, expenseMetadata)
        {
        }

        public override bool Validate()
        {
            foreach (Split split in Splits)
            {
                if (!(split is EqualSplit))
                {
                    return false;
                }
            }

            return true;
        }
    }
}

