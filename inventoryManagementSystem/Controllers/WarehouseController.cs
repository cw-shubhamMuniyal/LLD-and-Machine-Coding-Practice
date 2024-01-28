using inventoryManagementSystem.Model;

namespace inventoryManagementSystem.Controllers
{
    public class WarehouseController
    {
        List<Warehouse> warehouses = new();
        IWarehouseSelectionStratergy _warehouseSelectionStratergy;
        public WarehouseController(IWarehouseSelectionStratergy warehouseSelectionStratergy)
        {
            _warehouseSelectionStratergy = warehouseSelectionStratergy;
        }
        public void AddWarehouse(Warehouse warehouse)
        {
            warehouses.Add(warehouse);
        }
        public void RemoveWarehouse(Warehouse warehouse)
        {
            warehouses.Remove(warehouse);
        }
        public Warehouse SelectWarehouse(IWarehouseSelectionStratergy selectionStrategy)
        {
            _warehouseSelectionStratergy = selectionStrategy;
            return _warehouseSelectionStratergy.SelectWarehouse(warehouses);
        }
    }
}