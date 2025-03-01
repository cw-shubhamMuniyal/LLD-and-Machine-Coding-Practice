using System.Collections.Generic;
using Model;
using Service;

namespace Commands // Replace with your desired namespace
{
    /// <summary>
    /// Executor to handle the command of fetching the current status of the parking lot. It gives which
    /// slot has which car. Car details will have both its registration number and its color.
    /// </summary>
    public class StatusCommandExecutor : CommandExecutor
    {
        public static string COMMAND_NAME = "status";

        public StatusCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter)
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
            List<Slot> occupiedSlots = parkingLotService.GetOccupiedSlots();

            if (occupiedSlots.Count == 0)
            {
                outputPrinter.ParkingLotEmpty();
                return;
            }

            outputPrinter.statusHeader();
            foreach (Slot slot in occupiedSlots)
            {
                Car parkedCar = slot.ParkedCar;
                string slotNumber = slot.Id.ToString();

                outputPrinter.PrintWithNewLine(PadString(slotNumber, 12)
                    + PadString(parkedCar.RegistrationNumber, 19) + parkedCar.Color);
            }
        }

        private static string PadString(string word, int length)
        {
            string newWord = word;
            for (int count = word.Length; count < length; count++)
            {
                newWord = newWord + " ";
            }
            return newWord;
        }
    }
}
