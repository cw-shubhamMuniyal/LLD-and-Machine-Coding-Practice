using Logic;
using Model;

namespace TicTacToe;

class Program
{
    static void Main(string[] args)
    {       
            Game game = new Game(new Board(3), 3);
            game.InitializeGame(3);
            game.PlayGame();     

    }
}
