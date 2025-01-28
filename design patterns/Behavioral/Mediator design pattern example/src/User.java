public interface User {

    void recieveMessage(String message, String senderName);
    void sendMessage(String message);
    String getName();
}
