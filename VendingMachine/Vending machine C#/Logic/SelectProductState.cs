using VendingMachine.Model;

namespace VendingMachine.Logic
{
    class SelectProductState : IState
    {
        public void DispenseProduct(Machine Machine, int code)
        {
            throw new NotImplementedException();
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

        public void SelectProduct(Machine Machine, int code)
        {
            Item item = Machine.Inventory.GetItemByCode(code);
            int itemPrice = item.Price;
            int actualPricePaidByUser = 0;
            foreach (Coin coin in Machine.Coins)
            {
                actualPricePaidByUser += (int)coin;
            }
            if (itemPrice > actualPricePaidByUser)
            {
                Console.WriteLine("refunding user as item price of product is higher");
                Console.WriteLine("refunding " + actualPricePaidByUser + " to user");
                Console.WriteLine("And going into idle state");
                Machine.SetState(new IdleState());
                throw new Exception("Insufficient Balance");
            }
            else
            {
                Console.WriteLine("price paid by user");
                Console.WriteLine("returing additional " + (actualPricePaidByUser - itemPrice) + " paid by user");
                Console.WriteLine("Going into Dispense product state");
                Machine.SetState(new DispenseProductState());

            }
        }
    }
}