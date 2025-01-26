public class LightTurnOffCommand implements Command{

    private final LightReciever lightReciever;

    public LightTurnOffCommand(LightReciever lightReciever) {
        this.lightReciever = lightReciever;
    }

    @Override
    public void execute() {
        this.lightReciever.turnOff();
    }

    @Override
    public void undoExecute() {
        this.lightReciever.turnOn();
    }
}
