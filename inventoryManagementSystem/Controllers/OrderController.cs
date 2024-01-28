using inventoryManagementSystem.Logic;
using inventoryManagementSystem.Model;

namespace inventoryManagementSystem.Controllers
{
    public class OrderController
    {
        List<Order> orders;
        Dictionary<string, List<Order>> userIdVsOrders;
        public OrderController()
        {
            orders = new();
            userIdVsOrders = new();
        }
        public Order AddOrder(User user, Payment payment, Invoice invoice, Warehouse warehouse)
        {
            Order order = new Order(user, payment, invoice, warehouse);
            orders.Add(order);
            if (userIdVsOrders.ContainsKey(user.Id))
            {
                List<Order> orders = userIdVsOrders.GetValueOrDefault(user.Id);
                orders.Add(order);
                userIdVsOrders.Add(user.Id, orders);
            }
            else
            {
                userIdVsOrders.Add(user.Id, new List<Order> { order });
            }
            return order;
        }
        public List<Order> GetOrdersByUserId(string userId)
        {
            if (userIdVsOrders.ContainsKey(userId))
            {
                return userIdVsOrders.GetValueOrDefault(userId);
            }
            return new();
        }

        public Order getOrderByOrderId(string orderId)
        {
            Order order = null;
            var orderList = orders.Where(order => order.Id == orderId);
            if(orderList == null || orderList.Count() == 0)
            {
                return order;
            }
            order = orderList.FirstOrDefault();
            return order;
        }
    }
}