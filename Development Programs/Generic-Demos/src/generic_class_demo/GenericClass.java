package generic_class_demo;

public class GenericClass<T> {
    T obj;

    public GenericClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return this.obj;
    }
}

class GenericClassTest {
    /**
     * generic class is same generic constructor we are doing both in this example
     *
     * @param args
     */
    public static void main(String[] args) {
        GenericClass<String> stringGenericClass = new GenericClass<>("Jagdish");
        System.out.println(stringGenericClass.getObj());

        GenericClass<Integer> integerGenericClass = new GenericClass(12);
        System.out.println(integerGenericClass.getObj());


    }
}
