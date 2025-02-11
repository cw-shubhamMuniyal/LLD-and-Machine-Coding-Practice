using Logic;

namespace SnakeAndLadder;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello, World!");
        Game game = new Game();
        game.InitializeGame();
        game.PlayGame();
    }
}
