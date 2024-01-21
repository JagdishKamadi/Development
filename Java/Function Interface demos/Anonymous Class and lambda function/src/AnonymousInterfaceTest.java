public class AnonymousInterfaceTest {
    public static void main(String[] args) {
        // we cannot create the object of interface
        //  we can use here anonymous interface

        AnonymousInterface anonymousInterface = new AnonymousInterface() {
            @Override
            public void show() {
                System.out.println("Hey anonymous interface ");
            }
        };

        // at last, we have to call that method
        anonymousInterface.show();
    }
}
