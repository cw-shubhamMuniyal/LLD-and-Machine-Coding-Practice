using VendingMachine.Model;

namespace VendingMachine.Logic
{
    class AcceptMoneyState : IState
    {
        public void PressInsertCoin(Machine Machine)
        {
            throw new NotImplementedException();
        }
        public void InsertCoin(Machine Machine, Coin Coin)
        {
            Console.WriteLine("Going into accept money state again after getting more coins");
            Machine.Coins.Add(Coin);
            Machine.SetState(new AcceptMoneyState());
        }

        public void PressSelectProduct(Machine Machine)
        {
            Console.WriteLine("Going into Select Product");
            Machine.SetState(new SelectProductState());
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

        public void DispenseProduct(Machine Machine, int code)
        {
            throw new NotImplementedException();
        }
    }
}