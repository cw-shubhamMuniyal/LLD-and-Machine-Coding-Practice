public class UserImpl implements User {

    private final String name;
    private final ChatMediator chatMediator;

    UserImpl(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
        this.chatMediator.registerUser(this);
    }

    @Override
    public void recieveMessage(String message, String senderName) {
        System.out.println("Message received is " + message + " by " + this.name + " from " + senderName);
    }

    @Override
    public void sendMessage(String message) {
        this.chatMediator.sendMessage(this, message);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
