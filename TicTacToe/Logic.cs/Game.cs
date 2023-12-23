using Exceptions;
using Model;

namespace Logic
{
    public class Game
    {
        public Game(Board board, int numOfPlayers)
        {
            Board = board;
            Players = new List<Player>();
        }
        public Board Board { get; set; }
        public List<Player> Players { get; }

        public void InitializeGame(int capacity)
        {
            Board = new Board(capacity);
            for(int i=0;i<capacity;i++)
            {
                Board.PlayingBoard[i] = new Piece[capacity];
            }
            Players.Add(new Player("player A", new Piece(PieceType.X)));
            Players.Add(new Player("player B", new Piece(PieceType.O)));
        }

        public void PlayGame()
        {
            int row = 0, col = 0, count = 0;
            PieceType pieceType;
            bool isPieceMarked = false;
            while (true)
            {
                 if(Board.IsBoardFilled())
                {
                    Console.WriteLine("Tie");
                    break;
                }
                if(isPieceMarked)
                {
                    count++;
                }
                Board.PrintBoard();
                if(count%2 == 0)
                {
                    Console.Write($"Enter {Players[0].Name}  position: ");
                    pieceType = Players[0].Piece.Type;
                }
                else
                {
                    Console.Write($"Enter {Players[1].Name}  position: ");
                    pieceType = Players[1].Piece.Type;
                }
                string? input = null;
                using (var reader = new StreamReader(Console.OpenStandardInput()))
                {
                    input = reader.ReadLine();
                }
                List<string> tokens = input.Trim().Split(" ")
                                .Where(token => token.Length > 0).ToList();
                if (tokens.Count != 2)
                {
                    throw new InvalidCommandException();
                }
                int.TryParse(tokens[0], out row);
                int.TryParse(tokens[1], out col);
                isPieceMarked = MarkPiece(row, col, pieceType);
                bool isGameEnded = IsThereWinner(row, col, pieceType);
                if (isGameEnded)
                {
                    if(count%2 == 0)
                    {
                        Console.WriteLine($"{Players[0].Name}  Won");
                    }
                    else
                    {
                        Console.WriteLine($"{Players[1].Name}  Won");
                    }
                    
                    break;
                }
            }
        }

        public bool MarkPiece(int row, int col, PieceType pieceType)
        {
            if (row < 0 || row > Board.Capacity || col < 0 || col > Board.Capacity)
            {
                Console.WriteLine("incorrect position");
                return false;
            }
            if (Board.PlayingBoard[row][col] != null)
            {
                Console.WriteLine("position already filled");
                return false;
            }
            Board.AddPiece(row, col, new Piece(pieceType));
            return true;
        }
        public bool IsThereWinner(int row, int col, PieceType pieceType)
        {
            int count = 0;
            // horizontal checl
            for (int i = 0; i < Board.Capacity; i++)
            {
                if (Board.PlayingBoard[row][i] == null || Board.PlayingBoard[row][i].Type != pieceType)
                {
                    break;
                }
                count++;
            }
            if (count == Board.Capacity)
            {
                Console.WriteLine("Player" + pieceType.ToString() + " won");
                return true;
            }
            count = 0;
            // vertical checl
            for (int i = 0; i < Board.Capacity; i++)
            {
                if (Board.PlayingBoard[i][col] == null || Board.PlayingBoard[i][col].Type != pieceType)
                {
                    break;
                }
                count++;
            }
            if (count == Board.Capacity)
            {
                Console.WriteLine("Player" + pieceType.ToString() + " won");
                return true;
            }
            count = 0;
            // diagonal check
            for (int i = 0; i < Board.Capacity; i++)
            {
                if (Board.PlayingBoard[i][i] == null || Board.PlayingBoard[i][i].Type != pieceType)
                {
                    break;
                }
                count++;
            }
            count = 0;
            for (int i = 0, j = Board.Capacity - 1; i < Board.Capacity && j >= 0; i++, j--)
            {
                if (Board.PlayingBoard[i][j] == null || Board.PlayingBoard[i][j].Type != pieceType)
                {
                    break;
                }
                count++;
            }
            if (count == Board.Capacity)
            {
                return true;
            }
            return false;
        }
    }
}

