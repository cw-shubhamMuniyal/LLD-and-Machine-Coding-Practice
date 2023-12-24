namespace Model
{
    public class Ladder
    {
        public int StartPosition { get; set;}
        public int EndPosition { get; set;}
        public Ladder(int startPosition, int endPosition)
        {
            this.StartPosition = startPosition;
            this.EndPosition = endPosition;

        }
    }
}
