using Model;

namespace Logic;

public static class ExpenseService
{
    public static Expense CreateExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata)
    {
        switch (expenseType)
        {
            case ExpenseType.EXACT:
                return new ExactExpense(amount, paidBy, splits, expenseMetadata);

            case ExpenseType.PERCENT:
                foreach (Split split in splits)
                {
                    PercentSplit percentSplit = (PercentSplit)split;
                    split.Amount = (amount * percentSplit.Percent) / 100.0;
                }
                return new PercentExpense(amount, paidBy, splits, expenseMetadata);

            case ExpenseType.EQUAL:
                int totalSplits = splits.Count;
                double splitAmount = Math.Round(amount * 100 / totalSplits) / 100.0;
                foreach (Split split in splits)
                {
                    split.Amount = splitAmount;
                }
                splits[0].Amount = splitAmount + (amount - splitAmount * totalSplits);
                return new EqualExpense(amount, paidBy, splits, expenseMetadata);

            default:
                return null;
        }
    }
}
