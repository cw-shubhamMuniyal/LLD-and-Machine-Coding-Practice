import UiElements.Button.Button;
import UiElements.Textbox.Textbox;

public class AbstractFactoryExample {

    public static void main(String[] args) throws Exception {

        System.out.println("Abstract Factory method Example!");
        UiFactory uiFactory = GuiFactory.getUiFactory("mac");

        Button button = uiFactory.getButton();
        button.pressButton();

        Textbox textbox = uiFactory.getTextbox();
        textbox.readText();
    }
    
}
