package thread_unsafe;

public class ThreadUnsafeClassTest {
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

        // Ideally value of the count should be 2000,
        // but it won't print the 2000
        // because 2 thread access the resources same time which cause inconsistency
        System.out.println(counter.count);
    }
}
