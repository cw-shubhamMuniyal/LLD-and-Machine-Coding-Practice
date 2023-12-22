using Service;
using Mo = Mode;
using Exceptions;
using Commands;
using Mode;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello, World!");
         OutputPrinter outputPrinter = new OutputPrinter();
         ParkingLotService parkingLotService = new ParkingLotService();
         CommandExecutorFactory commandExecutorFactory =
            new CommandExecutorFactory(parkingLotService);

        if (IsInteractiveMode(args))
        {
            new InteractiveMode(commandExecutorFactory, outputPrinter).Process();
        }
        else if (IsFileInputMode(args))
        {
            new Mo.FileMode(commandExecutorFactory, outputPrinter, args[0]).Process();
        }
        else
        {
            throw new InvalidModeException();
        }
    }

    /**
     * Checks whether the program is running using file input mode.
     *
     * @param args Command line arguments.
     * @return Boolean indicating whether in file input mode.
     */
    private static bool IsFileInputMode(string[] args)
    {
        return args.Length == 1;
    }

    /**
     * Checks whether the program is running using interactive shell mode.
     *
     * @param args Command line arguments.
     * @return Boolean indicating whether in interactive shell mode.
     */
    private static bool IsInteractiveMode(string[] args)
    {
        return args.Length == 0;
    }
}
