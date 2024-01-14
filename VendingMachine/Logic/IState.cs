using VendingMachine.Model;

namespace VendingMachine.Logic
{
    public interface IState
    {
        public void PressInsertCoin(Machine Machine);
        public void PressSelectProduct(Machine Machine);
        public void SelectProduct(Machine Machine, int code);
        public void InsertCoin(Machine Machine, Coin Coin);
        public void RefundMoney(Machine Machine);
        public void DispenseProduct(Machine Machine, int code);

    }
}