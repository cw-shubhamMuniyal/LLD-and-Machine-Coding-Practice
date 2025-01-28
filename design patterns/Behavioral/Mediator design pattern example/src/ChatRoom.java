import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator {

    private final List<User> users = new ArrayList<>();

    @Override
    public void registerUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(User user, String message) {
        for (User user1 : users) {
            if (!user.equals(user1)) {
                user1.recieveMessage(message, user.getName());
            }
        }
    }

}
