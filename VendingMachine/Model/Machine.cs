using VendingMachine.Logic;

namespace VendingMachine.Model
{
    public class Machine
    {
        public IState State { get; set; }
        public Inventory Inventory { get; set; }
        public List<Coin> Coins { get; private set; } = new();
        public void SetState(IState state)
        {
            State = state;
        }
    }
}