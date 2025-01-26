public class LightTurnOnCommand implements Command{

    private final LightReciever lightReciever;

    public LightTurnOnCommand(LightReciever lightReciever) {
        this.lightReciever = lightReciever;
    }

    @Override
    public void execute() {
        lightReciever.turnOn();
    }

    @Override
    public void undoExecute() {
        lightReciever.turnOff();
    }
}
