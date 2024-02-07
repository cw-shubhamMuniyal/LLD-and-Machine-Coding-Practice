import java.lang.Thread.State;

/**
 * ThreadTester
 */
public class ThreadTester {

    public static void main(String[] args) {

        System.out.println("Main started");
        // Thread thread1 = new Thread1("thread 1 decorated");
        // thread1.start();

        // Thread thread2 = new Thread(() -> {
        // Thread thread = Thread.currentThread();
        // for (int i = 0; i < 10; i++) {
        // System.out.println("Thread name " + thread.getName()
        // + " priority " + thread.getPriority() + " parent thread " + " main");
        // }
        // }, "thread 2 decorated");
        // thread2.start();

        // Stack stack = new Stack(200);
        // Thread thread3 = new Thread(() -> {
        // for(int i = 0;i<100;i++) {
        // stack.push(i);
        // }
        // }, "pusher");
        // thread3.start();

        // Thread thread4 = new Thread(() -> {
        // for(int i = 0;i<100;i++) {
        // stack.pop();
        // }
        // }, "popper");
        // thread4.start();

        // Thread thread4 = new Thread(() -> {
        // try {
        // Thread.sleep(1);
        // }
        // catch(InterruptedException ex) {
        // ex.printStackTrace();
        // }
        // for(int i=0;i<10000;i++);
        // }, "thread4");
        // thread4.start();
        // State state = thread4.getState();
        // System.out.println(state);
        // while (true) {
        // state = thread4.getState();
        // System.out.println(state);
        // if(state == State.TERMINATED) {
        // break;
        // }
        // }

        // join
        // Thread thread5 = new Thread(() -> {
        // for(int i=0;i<1000000;i++);
        // System.out.println("entering into run function");
        // }, "thread 5");
        // thread5.start();
        // try {
        // thread5.join(1);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }

        // Deadlock : due to reverse ordering of locks
        // Object lock1 = new Object();
        // Object lock2 = new Object();

        // Thread thread6 = new Thread(() -> {
        //     synchronized (lock1) {
        //         System.out.println("checking");
        //         synchronized (lock2) {
        //             System.out.println("acquired lock");
        //         }
        //     }
        // });

        // Thread thread7 = new Thread(() -> {
        //     synchronized (lock2) {
        //         System.out.println("checking");
        //         synchronized (lock1) {
        //             System.out.println("acquired lock");
        //         }
        //     }
        // });
        // thread6.start();
        // thread7.start();

        // solution to above problem
        // reverse locks: same ordering of locks for all threads
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread6 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("checking");
                synchronized (lock2) {
                    System.out.println("acquired lock");
                }
            }
        });

        Thread thread7 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("checking");
                synchronized (lock2) {
                    System.out.println("acquired lock");
                }
            }
        });
        thread6.start();
        thread7.start();

        System.out.println("Main ended");
    }
}