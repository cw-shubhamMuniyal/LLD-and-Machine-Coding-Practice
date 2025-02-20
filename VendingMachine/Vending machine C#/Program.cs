using VendingMachine.Logic;
using VendingMachine.Model;

namespace VendingMachine;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Creating Vending Machine instance");
        Machine machine = new Machine();

        Console.WriteLine("Setting inventory");
        SetInventory(machine);

        Console.WriteLine("Going into idle state");
        machine.SetState(new IdleState());

        machine.State.PressInsertCoin(machine);
        machine.State.InsertCoin(machine, Coin.Penny);
        machine.State.InsertCoin(machine, Coin.Penny);
        machine.State.InsertCoin(machine, Coin.Penny);
        machine.State.InsertCoin(machine, Coin.Penny);
        machine.State.InsertCoin(machine, Coin.Penny);
        machine.State.InsertCoin(machine, Coin.Nickel);
        // machine.State.InsertCoin(machine, Coin.Dime);

        machine.State.PressSelectProduct(machine);

        machine.State.SelectProduct(machine, 110);

        machine.State.DispenseProduct(machine, 110);
    }

    private static void SetInventory(Machine machine)
    {
        int slots = 12, code = 100;
        machine.Inventory = new();
        machine.Inventory.InitializeInventory();
        for (int i = 0; i < slots; i++)
        {
            if(i >= 0 && i< 3)
            {
                machine.Inventory.Add(new Item(ItemType.Coke, 10), code++);
            }
            if(i >= 3 && i< 6)
            {
                machine.Inventory.Add(new Item(ItemType.Soda, 15), code++);
            }
            if(i >= 6 && i< 9)
            {
                machine.Inventory.Add(new Item(ItemType.Pepsi, 20), code++);
            }
            if(i >= 9 && i< 12)
            {
                machine.Inventory.Add(new Item(ItemType.Water, 5), code++);
            }
        }
    }
}
