using Logic;
using Model;

namespace Split_Wise;

class Program
{
    public static void Main(string[] args)
    {
        ExpenseManager expenseManager = new ExpenseManager();

        expenseManager.AddUser(new User("u1", "User1", "gaurav@workat.tech", "9876543210"));
        expenseManager.AddUser(new User("u2", "User2", "sagar@workat.tech", "9876543210"));
        expenseManager.AddUser(new User("u3", "User3", "hi@workat.tech", "9876543210"));
        expenseManager.AddUser(new User("u4", "User4", "mock-interviews@workat.tech", "9876543210"));

        while (true)
        {
            string command = Console.ReadLine();
            string[] commands = command.Split(' ');
            string commandType = commands[0];

            switch (commandType)
            {
                case "SHOW":
                    if (commands.Length == 1)
                    {
                        expenseManager.ShowBalances();
                    }
                    else
                    {
                        expenseManager.ShowBalance(commands[1]);
                    }
                    break;

                case "EXPENSE":
                    string paidBy = commands[1];
                    double amount = double.Parse(commands[2]);
                    int noOfUsers = int.Parse(commands[3]);
                    string expenseType = commands[4 + noOfUsers];
                    List<Split> splits = new List<Split>();

                    switch (expenseType)
                    {
                        case "EQUAL":
                            for (int i = 0; i < noOfUsers; i++)
                            {
                                splits.Add(new EqualSplit(expenseManager.UserMap[commands[4 + i]]));
                            }
                            expenseManager.AddExpense(ExpenseType.EQUAL, amount, paidBy, splits, null);
                            break;

                        case "EXACT":
                            for (int i = 0; i < noOfUsers; i++)
                            {
                                splits.Add(new ExactSplit(expenseManager.UserMap[commands[4 + i]], double.Parse(commands[5 + noOfUsers + i])));
                            }
                            expenseManager.AddExpense(ExpenseType.EXACT, amount, paidBy, splits, null);
                            break;

                        case "PERCENT":
                            for (int i = 0; i < noOfUsers; i++)
                            {
                                splits.Add(new PercentSplit(expenseManager.UserMap[commands[4 + i]], double.Parse(commands[5 + noOfUsers + i])));
                            }
                            expenseManager.AddExpense(ExpenseType.PERCENT, amount, paidBy, splits, null);
                            break;
                    }
                    break;
            }
        }
    }
}
