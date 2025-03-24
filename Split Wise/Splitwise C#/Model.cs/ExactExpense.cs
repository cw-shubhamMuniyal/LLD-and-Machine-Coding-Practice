using System.Collections.Generic;
namespace Model;
public class ExactExpense : Expense
{
    public ExactExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata)
        : base(amount, paidBy, splits, expenseMetadata)
    {
    }

    public override bool Validate()
    {
        foreach (Split split in Splits)
        {
            if (!(split is ExactSplit))
            {
                return false;
            }
        }

        double totalAmount = Amount;
        double sumSplitAmount = 0;

        foreach (Split split in Splits)
        {
            ExactSplit exactSplit = (ExactSplit)split;
            sumSplitAmount += exactSplit.Amount;
        }

        if (totalAmount != sumSplitAmount)
        {
            return false;
        }

        return true;
    }
}
