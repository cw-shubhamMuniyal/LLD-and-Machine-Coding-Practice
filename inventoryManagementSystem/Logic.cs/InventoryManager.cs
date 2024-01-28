using inventoryManagementSystem.Model;
using inventoryManagementSystem.Utilities;

namespace inventoryManagementSystem.Logic
{
    public class InventoryManager
    {
        public List<ProductCategory> ProductCategories;
        public InventoryManager()
        {
            ProductCategories = new();
        }

        public void AddProductCategory(string CategoryId, string categoryName, double price)
        {
            ProductCategories.Add(new ProductCategory(CategoryId, categoryName, price));
        }
        public void AddProduct(Product product, string productCategoryId)
        {
            foreach (ProductCategory productCategory in ProductCategories)
            {
                if (productCategory.Id == productCategoryId)
                {
                    productCategory.Products.Add(product);
                    return;
                }
            }
        }
        public void RemoveProduct(Dictionary<string, int> productCategoryIdAndCountMap)
        {
            if (productCategoryIdAndCountMap == null || productCategoryIdAndCountMap.Count == 0)
            {
                throw new Exception("map of product category vs count is empty");
            }
            foreach (KeyValuePair<string, int> keyValuePair in MapUtility<string, int>.GetKeyValuePairSet(productCategoryIdAndCountMap))
            {
                ProductCategory productCategory = GetProductCategoryById(keyValuePair.Key);
                productCategory.RemoveProducts(keyValuePair.Value);
            }
        }

        public ProductCategory GetProductCategoryById(string categoryId)
        {
            ProductCategory category = null;
            foreach (ProductCategory productCategory in ProductCategories)
            {
                if (productCategory.Id == categoryId)
                {
                    category = productCategory;
                    break;
                }
            }
            return category;
        }
    }
}