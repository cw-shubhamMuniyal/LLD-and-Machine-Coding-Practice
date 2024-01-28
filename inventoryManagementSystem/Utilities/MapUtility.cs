
namespace inventoryManagementSystem.Utilities
{
    public static class MapUtility<TKey, TValue>
    {
        public static ISet<KeyValuePair<TKey, TValue>> GetKeyValuePairSet(Dictionary<TKey, TValue> dictionary)
        {
            if(dictionary == null)
            {
                throw new Exception("Dictionary is null");
            }
            return new HashSet<KeyValuePair<TKey, TValue>>(dictionary);
        }
    }
}