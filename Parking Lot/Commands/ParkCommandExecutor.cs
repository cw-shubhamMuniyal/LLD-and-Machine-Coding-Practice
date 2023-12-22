using Commands;
using Service;
using Model;
using Exceptions; // Assuming namespace for Command model

namespace Commands // Replace with your desired namespace
{
    /// <summary>
    /// Executor to handle command of parking a car into the parking lot. This outputs the allotted slot
    /// in which the car is parked.
    /// </summary>
    public class ParkCommandExecutor : CommandExecutor
    {
        public static string COMMAND_NAME = "park";

        public ParkCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter)
            : base(parkingLotService, outputPrinter)
        {
        }

        /// <inheritdoc/>
        public override bool Validate(Command command)
        {
            return command.Params.Count == 2;
        }

        /// <inheritdoc/>
        public override void Execute(Command command)
        {
            Car car = new Car(command.Params[0], command.Params[1]);
            try
            {
                int? slot = parkingLotService.Park(car);
                outputPrinter.PrintWithNewLine("Allocated slot number: " + slot);
            }
            catch (NoFreeSlotAvailableException exception)
            {
                outputPrinter.ParkingLotFull();
            }
        }
    }
}
