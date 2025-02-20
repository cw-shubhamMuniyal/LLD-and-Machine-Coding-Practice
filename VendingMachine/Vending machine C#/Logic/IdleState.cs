using VendingMachine.Model;

namespace VendingMachine.Logic
{
    public class IdleState : IState
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
            Console.WriteLine("Going into accept money state after press insert coin operation");
            Machine.SetState(new AcceptMoneyState());
        }

        public void PressInsertCoin(Machine Machine, Coin Coin)
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
            throw new NotImplementedException();
        }
    }
}