namespace Logic
{
    public interface IEvictionPolicy
    {
        public void AccessedKey(string key);
        public string KeyToEvict();
    }
}