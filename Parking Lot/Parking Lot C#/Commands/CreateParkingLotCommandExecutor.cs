using System.Collections.Generic;
using Model;
using Model.Parking.Strategy;
using Service;

namespace Commands
{

    /**
     * Executor to handle command of creating the initial parking lot.
     */
    public class CreateParkingLotCommandExecutor : CommandExecutor
    {
        public static String COMMAND_NAME = "create_parking_lot";

        public CreateParkingLotCommandExecutor(
             ParkingLotService parkingLotService, OutputPrinter outputPrinter) : base(parkingLotService, outputPrinter)
        {

        }

        /**
         * {@inheritDoc}
         */
        public override bool Validate(Command command)
        {
            List<string> paramList = command.Params;
            if (paramList.Count != 1) {
                return false;
            }
            return int.TryParse(paramList[0], out int value);

        }

        /**
         * {@inheritDoc}
         */
        public override void Execute(Command command)
        {
            int.TryParse(command.Params[0], out int parkingLotCapacity);
            ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
            parkingLotService.createParkingLot(parkingLot, new NaturalOrderingParkingStrategy());
            outputPrinter.PrintWithNewLine(
                "Created a parking lot with " + parkingLot.Capacity + " slots");
        }
    }
}