namespace DS
{
    public class DLL
    {
        public Node Head { get; set; }
        public Node Tail { get; set; }
        public DLL()
        {
            Head = new Node();
            Tail = new Node();
            Head.Prev = null;
            Tail.Next = null;
            Head.Next = Tail;
            Tail.Prev = Head;
        }
        public void InsertAtFirst(Node node)
        {
            node.Next = Head.Next;
            node.Prev = Head;
            Head.Next = node;
            node.Next.Prev = node;
        }
        public void Remove(Node node)
        {
            node.Next.Prev = node.Prev;
            node.Prev.Next = node.Next;
        }
        public Node RemoveLast()
        {
            Node node = Tail.Prev;
            if(node != Head)
            {
                Tail.Prev = node.Prev;
                Tail.Prev.Next = Tail;
            }
            return node;
        }
        public void Print()
        {
            Node node = Head.Next;
            while(node != Tail)
            {
                Console.WriteLine(node.Value);
                node = node.Next;
            }
        }
    }
}