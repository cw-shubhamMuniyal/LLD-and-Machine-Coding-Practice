using Exceptions;

namespace Model
{
    /**
 * Model object to represent a input command.
 */
    public class Command
    {
        private const string space = " ";
        public string CommandName { get; set; }
        public List<string> Params { get; } = new List<string>();
        /**
   * Constructor. It takes the input line and parses the command name and param out of it. If the
   * command or its given params are not valid, then {@link InvalidCommandException} is thrown.
   *
   * @param inputLine Given input command line.
   */
        public Command(string inputLine)
        {
            List<string> tokens = inputLine.Trim().Split(space)
                                .Where(token => token.Length > 0).ToList();
            if (tokens.Count == 0)
            {
                throw new InvalidCommandException();
            }
            CommandName = tokens[0].ToLower();
            tokens.RemoveAt(0);
            Params = tokens;
        }
    }
}