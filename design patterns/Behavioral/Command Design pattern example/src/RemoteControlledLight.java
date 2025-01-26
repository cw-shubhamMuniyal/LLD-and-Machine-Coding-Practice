public class RemoteControlledLight {
    public static void main(String[] args) {

        System.out.println("Learning command pattern using remote controlled device example!");
        System.out.println("________________________________________________________________");

        LightReciever lightReciever = new LightReciever();

        Command turnOnLightCommand = new LightTurnOnCommand(lightReciever);
        Command turnOffLightCommand = new LightTurnOffCommand(lightReciever);

        LightInvoker lightInvoker = new LightInvoker(turnOnLightCommand, turnOffLightCommand);

        lightInvoker.clickTurnOnButton();
        lightInvoker.undoExecute();
        lightInvoker.clickTurnOffButton();
        lightInvoker.undoExecute();
    }
}