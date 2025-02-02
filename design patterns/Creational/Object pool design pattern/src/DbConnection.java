public class DbConnection {

    private static int counter = 1;

    public int getId() {
        return id;
    }

    private int id;

    public DbConnection() {
        id = counter++;
        System.out.println("Creating new db connection with id " + id);
    }

    public void connect() {
        System.out.println("Connecting to a db connection with id " + id);
    }
}
