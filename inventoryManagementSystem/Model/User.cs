namespace inventoryManagementSystem.Model
{
    public class User
    {
        public string Id { get; }
        public Address Address { get; }
        public Cart Cart { get; private set; }
        List<Order> Orders;
        public User(string id, Address address)
        {
            Id = id;
            Address = address;
            Orders = new();
            Cart = new();
        }
    }
}