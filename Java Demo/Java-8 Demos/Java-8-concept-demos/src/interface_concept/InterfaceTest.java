package interface_concept;

public class InterfaceTest implements A, B {
    public static void main(String[] args) {

        A a = new InterfaceTest();
        a.print();

        B b = new InterfaceTest();
        b.print();

        InterfaceTest interfaceTest = new InterfaceTest();
        interfaceTest.print();
    }

    @Override
    public void print() {
        System.out.println("Even I don't know from where I am calling, it's too weird");
    }
}


interface A {
    void print();
}

interface B {
    void print();
}