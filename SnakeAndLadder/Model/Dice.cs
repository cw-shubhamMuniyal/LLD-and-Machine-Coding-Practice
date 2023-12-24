namespace Model
{
    public class Dice
    {
        public int Number { get; set;}
        public int RollDice()
        {
            Random random = new Random();
            return random.Next(1, 6);
        }
    }
}
