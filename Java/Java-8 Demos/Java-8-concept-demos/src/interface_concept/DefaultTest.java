package interface_concept;

interface C {
    default String print() {
        return "A";
    }
}

class MyClass {
    public String print() {
        return "MyClass";
    }
}

public class DefaultTest extends MyClass implements C {

    public static void main(String[] args) {
        System.out.println(new DefaultTest().print());
    }
}
