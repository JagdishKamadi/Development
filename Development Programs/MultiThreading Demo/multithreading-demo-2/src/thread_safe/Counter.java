package thread_safe;

public class Counter {
    int count;

    public synchronized void increment() {
        count++;
    }

    // this is using the synchronized keyword block
    /*public void increment() {
        synchronized (this) {
            count++;
        }
    }*/
}