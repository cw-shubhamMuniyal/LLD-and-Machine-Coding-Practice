namespace VendingMachine.Model
{
    public class Item
    {
        public ItemType ItemType { get; set; }
        public int Price { get; set; }
        public Item() {}
        public Item(ItemType itemType, int price)
        {
            this.ItemType = itemType;
            this.Price = price;
        }
    }
}