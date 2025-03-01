using Commands;
using Model;

namespace Mode // Replace with your desired namespace
{
    /// <summary>
    /// Mode running in which input commands are given from a file.
    /// </summary>
    public class FileMode : Mode
    {
        private string fileName;

        public FileMode(
            CommandExecutorFactory commandExecutorFactory,
            OutputPrinter outputPrinter,
            string fileName)
            : base(commandExecutorFactory, outputPrinter)
        {
            this.fileName = fileName;
        }

        /// <inheritdoc/>
        public override void Process()
        { 
            try
            {
                using (StreamReader reader = new StreamReader(fileName))
                {
                    string input = reader.ReadLine();
                    while (input != null)
                    {
                        Command command = new Command(input);
                        ProcessCommand(command);
                        input = reader.ReadLine();
                    }
                }
            }
            catch (FileNotFoundException)
            {
                outputPrinter.InvalidFile();
            }
            catch (IOException ex)
            {
                Console.WriteLine($"An IOException occurred: {ex.Message}");
            }
        }
    }
}
