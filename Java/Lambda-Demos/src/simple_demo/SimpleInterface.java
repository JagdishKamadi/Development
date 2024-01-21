package simple_demo;

public interface SimpleInterface {
    void showMessage();

    // you can have no of default method
    // but only have one abstract method
    default void getMessage() {
        System.out.println("I am default method");
    }
}
