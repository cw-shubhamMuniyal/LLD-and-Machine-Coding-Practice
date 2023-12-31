using Logic;
using Model;

namespace Factory
{
    public class CacheFactory
    {
        public Cache<T> GetCacheManager<T>(string storage, string evictionPolicy)
        {
            if(storage == "dictionary" && evictionPolicy == "LRU")
            {
                return new Cache<T>(new DictionaryBasedStorage<T>(2), new LRUEvictionPolicy()); 
            }
            return null;
        }
    }
}