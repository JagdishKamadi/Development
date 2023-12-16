package thread_safe;

public class ThreadSafeClassTest {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        // we have to stop the main thread so that previous steps can execute
        t1.join();
        t2.join();

        // Now, it should print the 2000
        // as we have make counter class methods synchronized
        System.out.println(counter.count);
    }
}
