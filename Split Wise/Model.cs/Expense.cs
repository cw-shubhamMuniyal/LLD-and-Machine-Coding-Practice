
namespace Model
{
    public abstract class Expense
    {
        public string Id { get; set;}
        public User PaidBy { get; set;}
        public double Amount {get; set;}
        // public ExpenseType ExpenseType { get; set;}
        public List<Split> Splits {get; } = new();
        // public int NumberOfUsers { get; set;}
        public ExpenseMetadata Metadata { get; set;}
        public Expense(double amount, User paidBy, List<Split> splits, ExpenseMetadata metadata)
        {
            this.Amount = amount;
            this.PaidBy = paidBy;
            this.Splits = splits;
            this.Metadata = metadata;
        }
        public abstract bool Validate();
    }
}