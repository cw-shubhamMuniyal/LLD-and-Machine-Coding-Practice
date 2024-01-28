using inventoryManagementSystem.Logic;

namespace inventoryManagementSystem.Model
{
    //warehouse or store, which generally manages the inventory or act as Inventory controller
    public class Warehouse
    {
        public InventoryManager InventoryManager { get; set; }
        Address Address;

        //update inventory
        public void removeItemFromInventory(Dictionary<string, int> productCategoryAndCountMap)
        {
            //it will update the items in the inventory based upon product category.
            InventoryManager.RemoveProduct(productCategoryAndCountMap);
        }

        public void AddItemToInventory(Dictionary<int, int> productCategoryAndCountMap)
        {

            //it will update the items in the inventory based upon product category.
        }
    }

}