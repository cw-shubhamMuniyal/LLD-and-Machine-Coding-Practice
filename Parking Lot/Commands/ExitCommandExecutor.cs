using Service;
using Commands;
using Model;

namespace Commands // Replace with your desired namespace
{
    /// <summary>
    /// Executor to handle command of exiting from the parking lot service. This is used in interactive
    /// mode to exit.
    /// </summary>
    public class ExitCommandExecutor : CommandExecutor
    {
        public static string COMMAND_NAME = "exit";

        public ExitCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter)
            : base(parkingLotService, outputPrinter)
        {
        }

        /// <inheritdoc/>
        public override bool Validate(Command command)
        {
            return command.Params.Count == 0;
        }

        /// <inheritdoc/>
        public override void Execute(Command command)
        {
            outputPrinter.End();
        }
    }
}
