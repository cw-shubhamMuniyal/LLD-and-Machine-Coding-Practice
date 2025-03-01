using Commands;
using Model;

namespace Mode // Replace with your desired namespace
{
    /// <summary>
    /// Mode running in which input commands are given from an interactive shell.
    /// </summary>
    public class InteractiveMode : Mode
    {
        public InteractiveMode(
            CommandExecutorFactory commandExecutorFactory, OutputPrinter outputPrinter)
            : base(commandExecutorFactory, outputPrinter)
        {
        }

        /// <inheritdoc/>
        public override void Process()
        {
            outputPrinter.Welcome();
            using (var reader = new StreamReader(Console.OpenStandardInput()))
            {
                while (true)
                {
                    // Console.Write("> ");
                    Console.Write("create_parking_lot 6");
                    string input = reader.ReadLine();
                    Command command = new Command(input);
                    ProcessCommand(command);
                    if (command.CommandName.Equals(ExitCommandExecutor.COMMAND_NAME, StringComparison.OrdinalIgnoreCase))
                    {
                        break;
                    }
                }
            }
        }
    }
}
