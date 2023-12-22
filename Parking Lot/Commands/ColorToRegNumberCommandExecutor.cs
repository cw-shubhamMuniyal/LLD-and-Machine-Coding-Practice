using Model;
using Service;

namespace Commands
{

    /**
     * Executor to handle command of fetching all registration number of cars of a particular color.
     */
    public class ColorToRegNumberCommandExecutor : CommandExecutor
    {
        public static String COMMAND_NAME = "registration_numbers_for_cars_with_colour";

        public ColorToRegNumberCommandExecutor(
             ParkingLotService parkingLotService, OutputPrinter outputPrinter)
             : base(parkingLotService, outputPrinter)
        {
        }

        /**
         * {@inheritDoc}
         */
        public override bool Validate(Command command)
        {
            return command.Params.Count == 1;
        }

        /**
         * {@inheritDoc}
         */
        public override void Execute(Command command)
        {
            List<Slot> slotsForColor = parkingLotService.getSlotsForColor(command.Params[0]);
            if (slotsForColor.Count == 0)
            {
                outputPrinter.NotFound();
            }
            else
            {
                string result =
                    string.Join(", ", slotsForColor.Select(slot => slot.ParkedCar.RegistrationNumber));
                outputPrinter.PrintWithNewLine(result);
            }
        }

    }
}