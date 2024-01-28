namespace inventoryManagementSystem.Model
{
    public class Address
    {
        string Pincode;
        string City;
        public Address(string pincode, string city)
        {
            this.Pincode = pincode;
            this.City = city;
        }
    }
}