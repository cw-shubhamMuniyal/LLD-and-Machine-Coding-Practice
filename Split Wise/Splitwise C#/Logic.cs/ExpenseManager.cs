using Model;
namespace Logic;
public class ExpenseManager
{
    public List<Expense> Expenses;
    public Dictionary<string, User> UserMap;
    public Dictionary<string, Dictionary<string, double>> BalanceSheet;

    public ExpenseManager()
    {
        Expenses = new List<Expense>();
        UserMap = new Dictionary<string, User>();
        BalanceSheet = new Dictionary<string, Dictionary<string, double>>();
    }

    public void AddUser(User user)
    {
        UserMap[user.Id] = user;
        BalanceSheet[user.Id] = new Dictionary<string, double>();
    }

    public void AddExpense(ExpenseType expenseType, double amount, string paidBy, List<Split> splits, ExpenseMetadata expenseMetadata)
    {
        Expense expense = ExpenseService.CreateExpense(expenseType, amount, UserMap[paidBy], splits, expenseMetadata);
        Expenses.Add(expense);

        foreach (Split split in expense.Splits)
        {
            string paidTo = split.User.Id;
            Dictionary<string, double> balances = BalanceSheet[paidBy];
            
            if (!balances.ContainsKey(paidTo))
            {
                balances[paidTo] = 0.0;
            }

            balances[paidTo] += split.Amount;

            balances = BalanceSheet[paidTo];
            if (!balances.ContainsKey(paidBy))
            {
                balances[paidBy] = 0.0;
            }

            balances[paidBy] -= split.Amount;
        }
    }

    public void ShowBalance(string userId)
    {
        bool isEmpty = true;

        foreach (KeyValuePair<string, double> userBalance in BalanceSheet[userId])
        {
            if (userBalance.Value != 0)
            {
                isEmpty = false;
                PrintBalance(userId, userBalance.Key, userBalance.Value);
            }
        }

        if (isEmpty)
        {
            Console.WriteLine("No balances");
        }
    }

    public void ShowBalances()
    {
        bool isEmpty = true;

        foreach (KeyValuePair<string, Dictionary<string, double>> allBalances in BalanceSheet)
        {
            foreach (KeyValuePair<string, double> userBalance in allBalances.Value)
            {
                if (userBalance.Value > 0)
                {
                    isEmpty = false;
                    PrintBalance(allBalances.Key, userBalance.Key, userBalance.Value);
                }
            }
        }

        if (isEmpty)
        {
            Console.WriteLine("No balances");
        }
    }

    private void PrintBalance(string user1, string user2, double amount)
    {
        string user1Name = UserMap[user1].Name;
        string user2Name = UserMap[user2].Name;

        if (amount < 0)
        {
            Console.WriteLine($"{user1Name} owes {user2Name}: {Math.Abs(amount)}");
        }
        else if (amount > 0)
        {
            Console.WriteLine($"{user2Name} owes {user1Name}: {Math.Abs(amount)}");
        }
    }
}
