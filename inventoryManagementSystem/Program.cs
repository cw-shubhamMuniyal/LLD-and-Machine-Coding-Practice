using inventoryManagementSystem.Controllers;
using inventoryManagementSystem.Logic;
using inventoryManagementSystem.Model;

namespace inventoryManagementSystem;

// Copied into C# for learning
class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello, World!");

        Program mainObj = new Program();

        // 1. Create users in the system
        UserController userController = new UserController();
        Address address = new Address("230011", "nagar");
        userController.AddUser("1", address);

        //2. create warehouses in the system
        WarehouseController warehouseController = new WarehouseController(new NearestWarehouseSelectionStratergy());
        warehouseController.AddWarehouse(mainObj.AddWarehouseAndItsInventory());

        OrderController orderController = new OrderController();

        //3. feed the system with the initial informations
        ProductDeliverySystem productDeliverySystem = new ProductDeliverySystem(userController, warehouseController, orderController);

        mainObj.RunDeliveryFlow(productDeliverySystem, "1");
    }

    private Warehouse AddWarehouseAndItsInventory()
    {
        Warehouse warehouse = new Warehouse();

        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.AddProductCategory("0001", "Peppsii Large Cold Drink", 100);
        inventoryManager.AddProductCategory("0004", "Doovee small Soap", 50);

        //CREATE 3 Products

        Product product1 = new Product("1", "Peepsii");
        Product product2 = new Product("2", "Peepsii");
        Product product3 = new Product("3", "Doovee");

        inventoryManager.AddProduct(product1, "0001");
        inventoryManager.AddProduct(product2, "0001");
        inventoryManager.AddProduct(product3, "0004");

        warehouse.InventoryManager = inventoryManager;
        return warehouse;
    }

    private void RunDeliveryFlow(ProductDeliverySystem productDeliverySystem, string userId)
    {
        //1. Get the user object
        User user = productDeliverySystem.GetUser(userId);

        //2. get warehouse based on user preference
        Warehouse warehouse = productDeliverySystem.GetWarehouse(new NearestWarehouseSelectionStratergy());

        //3. get all the inventory to show the user
        InventoryManager inventoryManager = productDeliverySystem.GetInventory(warehouse);

        ProductCategory productCategoryIWantToOrder = null;
        foreach (ProductCategory productCategory in inventoryManager.ProductCategories)
        {
            if (productCategory.Name.Equals("Peppsii Large Cold Drink"))
            {
                productCategoryIWantToOrder = productCategory;
            }
        }

        //4. add product to the cart
        productDeliverySystem.AddProductToCart(user, productCategoryIWantToOrder, 2);

        //5. place order
        Order order = productDeliverySystem.PlaceOrder(user, new Payment(new UpiPaymentMode()), new Invoice(100, 10), warehouse);

        //6. checkout
        productDeliverySystem.Checkout(order);
    }
}
