namespace inventoryManagementSystem.Model
{
    public class ProductCategory
    {
        public string Id { get; private set; }
        public string Name { get; private set; }
        public List<Product> Products { get; private set; } = new();
        double Price;
        public ProductCategory(string id, string name, double price)
        {
            this.Id = id;
            this.Name = name;
            this.Price = price;
        }
        public void RemoveProducts(int count)
        {
            for (int i = 0; i < count; i++)
            {
                Products.RemoveAt(0);
            }
        }
    }
}