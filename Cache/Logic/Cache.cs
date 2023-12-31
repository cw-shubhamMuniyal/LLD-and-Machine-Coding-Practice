using Model;

namespace Logic
{
    public class Cache<T>
    {
        IStorage<T> _storage;
        IEvictionPolicy _evictionPolicy;
        public Cache(IStorage<T> storage, IEvictionPolicy evictionPolicy)
        {
            _storage = storage;
            _evictionPolicy = evictionPolicy;
        }
        public void Put(string key, T value)
        {
            if(_storage.DoesKeyExists(key))
            {
                _evictionPolicy.AccessedKey(key);
                _storage.UpdateKey(key, value);
            }
            else
            {
                if(_storage.IsStorageFull())
                {
                    string keyToRemove = _evictionPolicy.KeyToEvict();
                    _storage.RemoveKey(keyToRemove);
                }
                _storage.AddKey(key, value);
                _evictionPolicy.AccessedKey(key);
            }
        }
        public T Get(string key)
        {
            _evictionPolicy.AccessedKey(key);
            return _storage.Get(key);
        }
    }
}