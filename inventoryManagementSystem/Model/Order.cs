using inventoryManagementSystem.Logic;

namespace inventoryManagementSystem.Model
{
    public class Order
    {
        public string Id { get; }
        User _user;
        Address deliveryAddress;
        Warehouse _warehouse;
        Invoice _invoice;
        Payment _payment;
        public Order(User user, Payment payment, Invoice invoice, Warehouse warehouse)
        {
            Id = Guid.NewGuid().ToString();
            _user = user;
            _payment = payment;
            _invoice = invoice;
            _warehouse = warehouse;
        }
        public void Checkout()
        {
            deliveryAddress = _user.Address;
            Dictionary<string, int> ProductCategoryIdAndCountMapping = _user.Cart.getCartItems();
            bool isPaymentSuccess = _payment.MakePayment();
            if (isPaymentSuccess)
            {
                _warehouse.removeItemFromInventory(ProductCategoryIdAndCountMapping);
                _user.Cart.EmptyCart();
                _invoice.PrintInvoice();
            }
        }
    }
}