/*  Problem Statement
    Use Runnable interface to start a new thread and print numbers from 10 to 100
 */
public class ThreadTest {
    public static void main(String[] args) {

        // Lambda expression to print number from 10 to 100
        RunnableInterface runnableInterface = ()->
        {
            // simple for loop
            for(int i=10;i<=100;i++)
            {
                System.out.println(i+""+Thread.currentThread());
            }
        };

        // to run thread method
        // create thread class object
        Thread thread = new Thread(runnableInterface);
        // start the thread execution
//        thread.start();

        Runnable ran = new Runnable()
        {
          public void run()
          {
              for(int i=0;i<10;i++)
                  System.out.println("It's me dear : "+i);
          }
        };

        Thread t2 = new Thread(ran);
        t2.start();
    }
}

@FunctionalInterface
interface RunnableInterface extends Runnable
{
    @Override
    public void run();
}