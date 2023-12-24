using Model;

namespace Logic
{
    public class Game
    {
        public Board Board;
        public void InitializeGame()
        {
            Board = new Board(100);
            Board.AddSnake(90, 70);
            Board.AddSnake(70, 49);
            Board.AddSnake(49, 0);
            Board.AddLadder(30, 80);
            Board.AddLadder(90, 99);
            Board.AddLadder(20, 61);
            Board.AddPlayer("Shubham");
            Board.AddPlayer("Rahul");
        }

        public void PlayGame()
        {
            int numOfplayers = Board.Players.Count;
            int numOfplayersWon = 0;
            while (numOfplayersWon != numOfplayers - 1)
            {
                for (int i = 0; i < numOfplayers; i++)
                {
                    if (Board.Players[i].Status == PlayerStatus.Playing)
                    {
                        int diceValue = Board.Dice.RollDice();
                        int startPosition = Board.Players[i].Position;
                        if (Board.Players[i].Position + diceValue <= Board.Capacity)
                        {
                            Board.Players[i].Position += diceValue;
                        }
                        Board.Players[i].Position = MoveDownIfEncounterSnake(Board.Players[i].Position);
                        Board.Players[i].Position = MoveUpIfEncounterLadder(Board.Players[i].Position);
                        Console.WriteLine($"{Board.Players[i].Name} rolled a {diceValue} and moved from {startPosition} to {Board.Players[i].Position}");
                        if (Board.Players[i].Position == 100)
                        {
                            Console.WriteLine($"{Board.Players[i].Name} Won");
                            Board.Players[i].ChangeStatus(PlayerStatus.WON);
                            numOfplayersWon++;
                            if (numOfplayersWon == numOfplayers - 1)
                            {
                                break;
                            }
                        }
                    }

                }
            }
        }

        public int MoveDownIfEncounterSnake(int playerPosition)
        {
            int newPosition;
            do
            {
                newPosition = playerPosition;
                for (int i = 0; i < Board.Snakes.Count; i++)
                {
                    int snakeHeadPosition = Board.Snakes[i].Head;
                    int snakeTailPosition = Board.Snakes[i].Tail;
                    if (snakeHeadPosition == playerPosition)
                    {
                        Console.WriteLine("Encountered Snake");
                        playerPosition = snakeTailPosition;
                    }
                }
            }
            while (playerPosition != newPosition);
            return playerPosition;
        }

        public int MoveUpIfEncounterLadder(int playerPosition)
        {
            int newPosition;
            do
            {
                newPosition = playerPosition;
                for (int i = 0; i < Board.Ladders.Count; i++)
                {
                    int ladderStartPosition = Board.Ladders[i].StartPosition;
                    int ladderEndPosition = Board.Ladders[i].EndPosition;
                    if (ladderStartPosition == playerPosition)
                    {
                        Console.WriteLine("Encountered Ladder");
                        playerPosition = ladderEndPosition;
                    }
                }
            }
            while (playerPosition != newPosition);
            return playerPosition;
        }
    }
}