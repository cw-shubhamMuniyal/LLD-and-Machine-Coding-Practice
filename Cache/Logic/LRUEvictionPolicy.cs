using DS;

namespace Logic
{
    public class LRUEvictionPolicy : IEvictionPolicy
    {
        private Dictionary<string, Node> KeyNodePair;
        private DLL List;
        public LRUEvictionPolicy()
        {
            KeyNodePair = new Dictionary<string, Node>();
            List = new DLL();
        }
        public void AccessedKey(string key)
        {
            KeyNodePair.TryGetValue(key, out Node node);
            if(node != null)
            {
                List.Remove(node);
            }
            else
            {
                node = new Node(key);
                KeyNodePair.Add(key, node);
            }
            List.InsertAtFirst(node);
            List.Print();
        }

        public string KeyToEvict()
        {
            Node node = List.RemoveLast();
            List.Print();
            KeyNodePair.Remove(node.Value);
            return node.Value;
        }
    }
}