package simple_demo;

class SimpleInterfaceImplTest {
    public static void main(String[] args) {

        // using anonymous
        SimpleInterface simpleInterface = new SimpleInterfaceImpl() {
            public void showMessage() {
                System.out.println("Hello, I am working fine");
            }
        };
        simpleInterface.showMessage();

        // using lambda expression
        // now we cannot create lambda with class
        // note above point
        SimpleInterface simpleInterface1 = () -> System.out.println("I am working without class");
        simpleInterface1.showMessage();
        simpleInterface1.getMessage();


        SimpleInterfaceImpl simpleInterface2 = new SimpleInterfaceImpl() {
            public int get(int x) {
                return x;
            }
        };

        System.out.println("hello get() " + simpleInterface2.get(5));
    }
}