/*
    This is the simple example of Anonymous class
 */

public class AnonymousClass {
    public static void main(String[] args) {
        Test test = new Test()
        {
            public void show()
            {
                System.out.println("Hello Anonymous class");
            }
        };
        // now call that method
        test.show();

        Test2 test2 = new Test2()
        {
            public void show(int i)
            {
                System.out.println("My value is "+i);
            }
        };
        // now call that method
        test2.show(5);
    }
}


class Test
{
    public void show()
    {
        System.out.println("Hello, Jagdish");
    }
}

class Test2
{
    public void show(int k)
    {
        System.out.println("Hello, Jagdish "+k);
    }
}