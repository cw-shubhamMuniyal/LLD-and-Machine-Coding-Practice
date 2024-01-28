namespace inventoryManagementSystem.Model
{
    public class Product
    {
        string Id { get;  }
        string Name { get;  }
        public Product(string id, string name)
        {
            this.Id = id;
            this.Name = name;
        }
    }
}