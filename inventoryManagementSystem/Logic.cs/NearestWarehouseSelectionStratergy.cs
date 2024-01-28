using inventoryManagementSystem.Model;

namespace inventoryManagementSystem.Logic
{
    public class NearestWarehouseSelectionStratergy : IWarehouseSelectionStratergy
    {
        Warehouse IWarehouseSelectionStratergy.SelectWarehouse(List<Warehouse> warehouses)
        {
           //algo to pick the nearest algo, for now I am just picking the first warehouse for demo purpose
            if(warehouses != null && warehouses.Count != 0)
            {
                return warehouses[0];
            }
            return null;
        }
    }
}