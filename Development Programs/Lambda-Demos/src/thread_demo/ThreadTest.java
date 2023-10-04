package thread_demo;

public class ThreadTest {
    public static void main(String[] args) {

        // one way to run the thread
        // using anonymous class
        Runnable r1 = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("i + " + i);
                }
            }
        };

        Thread t1 = new Thread(r1);
        t1.setName("First thread");
        t1.start();

        // another way using lambda expression
        Runnable r2 = () -> {
            for (int i = 1; i < 10; i++) {
                System.out.println(i);
            }
        };

        Thread t2 = new Thread(r2);
        t2.start();
    }
}
