using Commands;
using Exceptions;
using Model;

namespace Mode
{

    /**
     * Interface for mode of the program in which it can be run.
     */
    public abstract class Mode
    {

        private CommandExecutorFactory commandExecutorFactory;
        protected OutputPrinter outputPrinter;

        public Mode(
            CommandExecutorFactory commandExecutorFactory, OutputPrinter outputPrinter)
        {
            this.commandExecutorFactory = commandExecutorFactory;
            this.outputPrinter = outputPrinter;
        }

        /**
         * Helper method to process a command. It basically uses {@link CommandExecutor} to run the given
         * command.
         *
         * @param command Command to be processed.
         */
        protected void ProcessCommand(Command command)
        {
            CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
            if (commandExecutor.Validate(command))
            {
                commandExecutor.Execute(command);
            }
            else
            {
                throw new InvalidCommandException();
            }
        }

        /**
         * Abstract method to process the mode. Each mode will process in its own way.
         *
         * @throws IOException
         */
        public abstract void Process();
    }
}