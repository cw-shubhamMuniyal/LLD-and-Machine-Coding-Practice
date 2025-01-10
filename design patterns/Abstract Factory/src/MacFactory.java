import UiElements.Button.Button;
import UiElements.Button.MacButton;
import UiElements.Textbox.MacTextbox;
import UiElements.Textbox.Textbox;

public class MacFactory implements UiFactory{

    @Override
    public Button getButton() {
        return new MacButton();
    }

    @Override
    public Textbox getTextbox() {
        return new MacTextbox();
    }
    
}
