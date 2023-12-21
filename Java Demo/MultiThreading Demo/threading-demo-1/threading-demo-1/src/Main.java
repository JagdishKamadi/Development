public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("myThread name : " + myThread.getName());
        myThread.setName("myThread");

//        to get the main thread name
        Thread thread = Thread.currentThread();
        System.out.println("Main thread name :" + thread.getName());
//        change the main thread name to  my thread
        thread.setName("Jagdish");
        System.out.println("Main thread  name changed to :" + thread.getName());

        // to see the priority
        System.out.println(myThread.getPriority());
        System.out.println(thread.getPriority());
        
    }
}