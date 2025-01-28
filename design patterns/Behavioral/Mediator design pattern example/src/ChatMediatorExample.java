public class ChatMediatorExample {
    public static void main(String[] args) {

        System.out.println("Learning Mediator design pattern with example!");
        System.out.println("______________________________________________");

        ChatMediator chatMediator = new ChatRoom();
        User sender = new UserImpl("sender", chatMediator);
        new UserImpl("receiver1", chatMediator);
        new UserImpl("receiver2", chatMediator);

        sender.sendMessage("Happy learning design patterns!!!");

    }
}