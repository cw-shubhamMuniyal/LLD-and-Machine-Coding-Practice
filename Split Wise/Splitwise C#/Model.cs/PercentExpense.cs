using System.Collections.Generic;
namespace Model;
public class PercentExpense : Expense
{
    public PercentExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata)
        : base(amount, paidBy, splits, expenseMetadata)
    {
    }

    public override bool Validate()
    {
        foreach (Split split in Splits)
        {
            if (!(split is PercentSplit))
            {
                return false;
            }
        }

        double totalPercent = 100;
        double sumSplitPercent = 0;

        foreach (Split split in Splits)
        {
            PercentSplit percentSplit = (PercentSplit)split;
            sumSplitPercent += percentSplit.Percent;
        }

        if (totalPercent != sumSplitPercent)
        {
            return false;
        }

        return true;
    }
}
