using inventoryManagementSystem.Controllers;
using inventoryManagementSystem.Model;

namespace inventoryManagementSystem.Logic
{
    public class ProductDeliverySystem
    {
        UserController _userController;
        WarehouseController _warehouseController;
        OrderController _orderController;
        public ProductDeliverySystem(UserController userController, WarehouseController warehouseController, OrderController orderController)
        {
            _userController = userController;
            _warehouseController = warehouseController;
            _orderController = orderController;
        }

        //get user object
        public User GetUser(string userId)
        {
            return _userController.GetUser(userId);
        }

        //get warehouse
        public Warehouse GetWarehouse(IWarehouseSelectionStratergy warehouseSelectionStrategy)
        {
            return _warehouseController.SelectWarehouse(warehouseSelectionStrategy);

        }

        //get inventory
        public InventoryManager GetInventory(Warehouse warehouse)
        {
            return warehouse.InventoryManager;

        }

        //add product to cart
        public void AddProductToCart(User user, ProductCategory productCategory, int count)
        {
            Cart cart = user.Cart;
            cart.AddItemsInCart(productCategory.Id, count);
        }

        //place order
        public Order PlaceOrder(User user, Payment payment, Invoice invoice, Warehouse warehouse)
        {
            return _orderController.AddOrder(user, payment, invoice, warehouse);
        }

        public void Checkout(Order order)
        {
            order.Checkout();
        }
    }
}