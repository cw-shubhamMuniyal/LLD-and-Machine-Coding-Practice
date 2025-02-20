using VendingMachine.Model;

namespace VendingMachine.Logic
{
    public class DispenseProductState : IState
    {
        public void DispenseProduct(Machine Machine, int code)
        {
            Console.WriteLine("Going into Idle state after dispensing product");
            Machine.Inventory.UpdateSoldOutItem(code);
            Machine.SetState(new IdleState());
        }

        public void InsertCoin(Machine Machine)
        {
            throw new NotImplementedException();
        }

        public void InsertCoin(Machine Machine, Coin Coin)
        {
            throw new NotImplementedException();
        }

        public void PressInsertCoin(Machine Machine)
        {
            throw new NotImplementedException();
        }

        public void PressSelectProduct(Machine Machine)
        {
            throw new NotImplementedException();
        }

        public void RefundMoney(Machine Machine)
        {
            throw new NotImplementedException();
        }

        public void SelectProduct(Machine Machine)
        {
            throw new NotImplementedException();
        }

        public void SelectProduct(Machine Machine, int code)
        {
            throw new NotImplementedException();
        }
    }
}