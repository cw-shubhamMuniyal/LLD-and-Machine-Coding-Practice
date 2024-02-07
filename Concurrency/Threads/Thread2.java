public class Thread2 implements Runnable{
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread name " + thread.getName()
                    + " priority " + thread.getPriority() + " parent thread " + " main");
        }
    }
}
