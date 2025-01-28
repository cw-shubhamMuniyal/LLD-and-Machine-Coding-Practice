public interface ChatMediator {

    void registerUser(User user);
    void sendMessage(User user, String message);
}
