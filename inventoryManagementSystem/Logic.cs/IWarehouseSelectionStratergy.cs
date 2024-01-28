using inventoryManagementSystem.Model;

public interface IWarehouseSelectionStratergy
{
    Warehouse SelectWarehouse(List<Warehouse> warehouses);
}