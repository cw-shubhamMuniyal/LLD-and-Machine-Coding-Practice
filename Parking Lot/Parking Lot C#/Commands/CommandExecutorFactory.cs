using Exceptions;
using Model;
using Service;

namespace Commands
{

    /**
     * Factory to get correct {@link CommandExecutor} from a given command.
     */
    public class CommandExecutorFactory
    {
        private Dictionary<String, CommandExecutor> commands = new();

        public CommandExecutorFactory(ParkingLotService parkingLotService)
        {
             OutputPrinter outputPrinter = new OutputPrinter();
            commands.Add(
                CreateParkingLotCommandExecutor.COMMAND_NAME,
                new CreateParkingLotCommandExecutor(parkingLotService, outputPrinter));
            commands.Add(
                ParkCommandExecutor.COMMAND_NAME,
                new ParkCommandExecutor(parkingLotService, outputPrinter));
            commands.Add(
                LeaveCommandExecutor.COMMAND_NAME,
                new LeaveCommandExecutor(parkingLotService, outputPrinter));
            commands.Add(
                StatusCommandExecutor.COMMAND_NAME,
                new StatusCommandExecutor(parkingLotService, outputPrinter));
            commands.Add(
                ColorToRegNumberCommandExecutor.COMMAND_NAME,
                new ColorToRegNumberCommandExecutor(parkingLotService, outputPrinter));
            commands.Add(
                ColorToSlotNumberCommandExecutor.COMMAND_NAME,
                new ColorToSlotNumberCommandExecutor(parkingLotService, outputPrinter));
            commands.Add(
                SlotForRegNumberCommandExecutor.COMMAND_NAME,
                new SlotForRegNumberCommandExecutor(parkingLotService, outputPrinter));
            commands.Add(
                ExitCommandExecutor.COMMAND_NAME,
                new ExitCommandExecutor(parkingLotService, outputPrinter));
        }

        /**
         * Gets {@link CommandExecutor} for a particular command. It basically uses name of command to
         * fetch its corresponding executor.
         *
         * @param command Command for which executor has to be fetched.
         * @return Command executor.
         */
        public CommandExecutor getCommandExecutor(Command command)
        {
            CommandExecutor commandExecutor;
            _ = commands.TryGetValue(command.CommandName, out commandExecutor);
            if (commandExecutor == null)
            {
                throw new InvalidCommandException();
            }
            return commandExecutor;
        }
    }
}