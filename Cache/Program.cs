using DS;
using Factory;
using Logic;

namespace Cache;

class Program
{
    static void Main(string[] args)
    {
        initializeCacheManager<string>();
    }

    static void initializeCacheManager<T>()
    {
        CacheFactory cacheFactory = new();
        Cache<T> cacheManager = cacheFactory.GetCacheManager<T>("dictionary", "LRU");
        cacheManager.Put("shubham", GetValue<T>("football"));
        cacheManager.Put("rahul", GetValue<T>("cricket"));
        Console.WriteLine(cacheManager.Get("shubham"));
        cacheManager.Put("vikram", GetValue<T>("tennis"));
        cacheManager.Put("shubham", GetValue<T>("TT"));
        Console.WriteLine(cacheManager.Get("shubham"));
        Console.WriteLine(cacheManager.Get("vikram"));
    }

    // genric type expects object
    // to convert string into generic type
    public static T GetValue<T>(String value)
    {
        return (T)Convert.ChangeType(value, typeof(T));
    }
}
