namespace VendingMachine.Model
{
    public class ItemShelf
    {
        public Item Item { get; set; }
        public int Code { get; set; }
        public bool IsSoldOut { get; set; }
        public ItemShelf(Item item, bool isSoldOut, int code)
        {
            this.Item = item;
            this.IsSoldOut = isSoldOut;
            this.Code = code;
        }
    }
}