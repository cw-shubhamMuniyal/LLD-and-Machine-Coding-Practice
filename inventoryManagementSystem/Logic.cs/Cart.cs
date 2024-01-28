namespace inventoryManagementSystem.Model
{
    public class Cart
    {
        Dictionary<string, int> productCategoryIdAndCountMapping;
        public Cart()
        {
            productCategoryIdAndCountMapping = new();
        }
        public void AddItemsInCart(string productCategoryId, int count)
        {
            if (productCategoryIdAndCountMapping.ContainsKey(productCategoryId))
            {
                int noOfItems = productCategoryIdAndCountMapping.GetValueOrDefault(productCategoryId);
                productCategoryIdAndCountMapping.Add(productCategoryId, noOfItems + count);
            }
            else
            {
                productCategoryIdAndCountMapping.Add(productCategoryId, count);
            }
        }

        public void RemoveItemsFromCart(string productCategoryId, int count)
        {
            if (productCategoryIdAndCountMapping.ContainsKey(productCategoryId))
            {
                int noOfItems = productCategoryIdAndCountMapping.GetValueOrDefault(productCategoryId);
                if (noOfItems > count)
                {
                    productCategoryIdAndCountMapping.Add(productCategoryId, noOfItems + count);
                }
                else if (noOfItems == count)
                {
                    productCategoryIdAndCountMapping.Remove(productCategoryId);
                }
                else
                {
                    throw new Exception($"Insufficient no of itmes present in cart with product id as  {productCategoryId}");
                }
            }
            else
            {
                throw new Exception($"No product category exists with id as  {productCategoryId}");
            }
        }
        public void EmptyCart()
        {
            productCategoryIdAndCountMapping.Clear();
        }
        //View Cart
        public Dictionary<string, int> getCartItems()
        {
            return productCategoryIdAndCountMapping;
        }
    }
}