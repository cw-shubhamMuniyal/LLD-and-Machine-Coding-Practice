public class Singleton {

    private static volatile Singleton instance;

    private int count;

    private Singleton(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "count=" + count +
                '}';
    }

    public static Singleton getInstance() {

        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(10);
                }
            }
        }
        return instance;
    }


}


