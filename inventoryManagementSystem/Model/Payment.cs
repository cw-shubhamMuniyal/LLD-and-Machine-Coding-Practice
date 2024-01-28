
namespace inventoryManagementSystem.Logic
{
    public class Payment
    {
        PaymentMode _paymentMode;
        public Payment(PaymentMode paymentMode)
        {
            _paymentMode = paymentMode;
        }
        public bool MakePayment()
        {
            return _paymentMode.MakePayment();
        }
    }
}