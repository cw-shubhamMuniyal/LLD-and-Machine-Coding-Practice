namespace VendingMachine.Model
{
    public class Inventory
    {
        public List<ItemShelf> Items { get; private set; } = new();
        public Item GetItemByCode(int code)
        {
            foreach(ItemShelf itemShelf in Items)
            {
                if(itemShelf.Code == code && !itemShelf.IsSoldOut)
                {
                    return itemShelf.Item;
                }
            }
            throw new Exception("item is sold out.");
        }
        public void InitializeInventory()
        {
            int startCode = 101;
            for(int i=0;i<100;i++)
            {
                Item item = new Item();
                Items.Add(new ItemShelf(item, true, startCode));
                startCode++;
            }
        }
        public void Add(Item item, int code)
        {
            foreach(ItemShelf itemShelf in Items)
            {
                if(itemShelf.Code == code && itemShelf.IsSoldOut)
                {
                    itemShelf.Item = item;
                    itemShelf.IsSoldOut = false;
                }
            }
        }

        public void UpdateSoldOutItem(int code)
        {
            foreach(ItemShelf itemShelf in Items)
            {
                if(itemShelf.Code == code && !itemShelf.IsSoldOut)
                {
                    itemShelf.IsSoldOut = true;
                }
            }
        }
    }
}