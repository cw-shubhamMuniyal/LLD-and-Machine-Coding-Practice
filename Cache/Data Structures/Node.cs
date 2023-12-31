namespace DS
{
    public class Node
    {
        public Node? Prev { get; set; }
        public Node? Next { get; set; }
        public string Value { get; set; }
        public Node(){}
        public Node(string value)
        {
            Value = value;
            Prev = null;
            Next = null;
        }
    }
}
