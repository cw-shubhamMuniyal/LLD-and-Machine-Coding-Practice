using Service;
using Model; // Assuming namespace for IntegerValidator

namespace Commands // Replace with your desired namespace
{
    /// <summary>
    /// Executor to handle command of freeing of slot from a car.
    /// </summary>
    public class LeaveCommandExecutor : CommandExecutor
    {
        public static string COMMAND_NAME = "leave";

        public LeaveCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter)
            : base(parkingLotService, outputPrinter)
        {
        }

        /// <inheritdoc/>
        public override bool Validate(Command command)
        {
            List<string> paramsList = command.Params;
            if (paramsList.Count != 1)
            {
                return false;
            }
            return int.TryParse(paramsList[0], out int value);
        }

        /// <inheritdoc/>
        public override void Execute(Command command)
        {
            int slotNum = int.Parse(command.Params[0]);
            parkingLotService.MakeSlotFree(slotNum);
            outputPrinter.PrintWithNewLine($"Slot number {slotNum} is free");
        }
    }
}
