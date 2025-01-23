public class Main {
    public static void main(String[] args) {

        System.out.println("Learning Singleton pattern!");
        System.out.println("___________________________");

        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.toString());
    }
}