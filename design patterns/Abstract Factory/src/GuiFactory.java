public class GuiFactory {

    public static UiFactory getUiFactory(String device) throws Exception {

        if (device.equals("windows")) {
            return new WindowFactory();
        } else if (device.equals("mac")) {
            return new MacFactory();
        }
        throw new Exception("please pass valid device!!" +
                "currently we only support windows and mac");

    }
}
