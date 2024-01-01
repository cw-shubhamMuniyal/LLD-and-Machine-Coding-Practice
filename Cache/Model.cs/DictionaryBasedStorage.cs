using DS;
using Exceptions;

namespace Model
{
    public class DictionaryBasedStorage<T> : IStorage<T>
    {
        public Dictionary<string, T> Dictionary { get; private set; } = new();
        public int Capacity { get; set; }
        public DictionaryBasedStorage(int capacity)
        {
            Capacity = capacity;
        }
        public void AddKey(string key, T value)
        {
            if (IsStorageFull())
            {
                throw new StorageFullException("storage Full");
            }
            Dictionary.Add(key, value);
        }
        public void RemoveKey(string key)
        {
            if(!Dictionary.ContainsKey(key))
            {
                throw new KeyNotFound("key not found");
            }
            Dictionary.Remove(key);
        }
        public void UpdateKey(string key, T value)
        {
            if(!Dictionary.ContainsKey(key))
            {
                throw new KeyNotFound("key not found");
            }
            Dictionary[key] = value;
        }
        public T Get(string key)
        {
            if(!DoesKeyExists(key))
            {
                throw new KeyNotFound("key not found");
            }
            Dictionary.TryGetValue(key, out var value);
            return value;
        }
        public bool DoesKeyExists(string key)
        {
            return Dictionary != null && Dictionary.ContainsKey(key);
        }
        public bool IsStorageFull()
        {
            return Dictionary != null && Dictionary.Count == Capacity;
        }
    }
}
