import UiElements.Button.Button;
import UiElements.Button.WinButton;
import UiElements.Textbox.Textbox;
import UiElements.Textbox.WinTextbox;

public class WindowFactory implements UiFactory{

    @Override
    public Button getButton() {
        return new WinButton();
    }

    @Override
    public Textbox getTextbox() {
        return new WinTextbox();
    }
    
}
