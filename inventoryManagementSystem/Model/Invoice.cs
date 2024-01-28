namespace inventoryManagementSystem.Model
{
    public class Invoice
    {
        double TotalPrice;
        double Tax;
        double FinalPrice;
        public Invoice(double totalPrice, double tax)
        {
            this.TotalPrice = totalPrice;
            this.Tax = tax;
        }
        public void PrintInvoice()
        {
            Console.WriteLine($"Total Price: {TotalPrice}, With tax amount {Tax}, and Final Price {TotalPrice- Tax}");
        }
    }
}