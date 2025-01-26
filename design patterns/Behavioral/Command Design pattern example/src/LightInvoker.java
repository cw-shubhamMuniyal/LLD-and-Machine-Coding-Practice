import java.util.ArrayList;
import java.util.List;

public class LightInvoker {

    Command turnOnCommand, turnOffCommand;
    List<Command> previousCommands = new ArrayList<>();

    public LightInvoker(Command turnOnCommand, Command turnOffCommand) {
        this.turnOnCommand = turnOnCommand;
        this.turnOffCommand = turnOffCommand;
    }

    public void clickTurnOnButton() {
        turnOnCommand.execute();
        previousCommands.add(turnOnCommand);
    }

    public void clickTurnOffButton() {
        turnOffCommand.execute();
        previousCommands.add(turnOffCommand);
    }

    public void undoExecute() {
        Command previousCommand = previousCommands.getLast();
        previousCommand.undoExecute();
    }
}
