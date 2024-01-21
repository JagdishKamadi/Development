package generic_interface_demo;

public class GenericInterfaceImpl<T, U> implements GenericInterface<T, U> {
    @Override
    public void showValues(T t1, U u1) {
        System.out.println(t1 + " " + t1.getClass().getName());
        System.out.println(u1 + " " + u1.getClass());
    }
}

class GenericInterfaceImplTest {
    public static void main(String[] args) {
        GenericInterface<String, String> genericInterface1 = new GenericInterfaceImpl<>();
        genericInterface1.showValues("Jagdish", "Tejas");

        GenericInterface<Integer, String> genericInterface2 = new GenericInterfaceImpl<>();
        genericInterface2.showValues(722, "Jagdish");

    }
}