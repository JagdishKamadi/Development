import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        // one way to do this
        //  it is also called lambda because consumer interface taking lambda expression
        list.forEach(i-> System.out.print(i+" "));

        System.out.println();
        // another way to write the same code
        Consumer<Integer> consumer = new Consumer<Integer>()
        {
            public void accept(Integer i)
            {
                System.out.print(i+" ");
            }
        };

        // it will print the same
        list.forEach(consumer);
        System.out.println();

        // another way of doing this
        Consumer<Integer> consumer1 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer+" ");
            }
        };
        list.forEach(consumer1);
        System.out.println();

        // using lambda expression
        // nothing to override accept method of consumer interface
        Consumer<Integer> consumer2 = (Integer i)->
        {
            System.out.print(i+" ");
        };
        // it is behaves like now lambda expression
        list.forEach(consumer2);
        System.out.println();

        // same thing do lambda expression
        // below is the example
        Consumer<Integer> consumer3 = (i)-> System.out.print(i+" ");
        list.forEach(consumer3);
        System.out.println();

        // so can we pass this -> {  (i)-> System.out.print(i+" ") }
        // off-course we can
        list.forEach(i-> System.out.print(i+" "));

    }
}

class ConsumerImpl implements Consumer<Integer>
{
    public void accept(Integer i)
    {
        System.out.print(i+" ");
    }
}