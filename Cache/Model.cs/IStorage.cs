namespace Model
{
    public interface IStorage<T>
    {
        public void AddKey(string key, T value);
        public void RemoveKey(string key);
        public void UpdateKey(string key, T value);
        public bool IsStorageFull();
        public bool DoesKeyExists(string key);
        public T Get(string key);
    }
}