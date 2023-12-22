using Commands;
using Model;
using Service;

namespace Commands // Replace with your desired namespace
{
    /// <summary>
    /// Executor to handle the command of fetching the slot number of a car with a given registration number.
    /// </summary>
    public class SlotForRegNumberCommandExecutor : CommandExecutor
    {
        public static string COMMAND_NAME = "slot_number_for_registration_number";

        public SlotForRegNumberCommandExecutor(
            ParkingLotService parkingLotService,
            OutputPrinter outputPrinter)
            : base(parkingLotService, outputPrinter)
        {
        }

        /// <inheritdoc/>
        public override bool Validate(Command command)
        {
            return command.Params.Count == 1;
        }

        /// <inheritdoc/>
        public override void Execute(Command command)
        {
            List<Slot> occupiedSlots = parkingLotService.GetOccupiedSlots();
            string regNumberToFind = command.Params[0];
            Slot? foundSlot = occupiedSlots?.FirstOrDefault(slot => slot != null &&
                slot.ParkedCar != null && slot.ParkedCar.RegistrationNumber != null &&
                slot.ParkedCar.RegistrationNumber.Equals(regNumberToFind));

            if (foundSlot != null)
            {
                outputPrinter.PrintWithNewLine(foundSlot.Id.ToString());
            }
            else
            {
                outputPrinter.NotFound();
            }
        }
    }
}
