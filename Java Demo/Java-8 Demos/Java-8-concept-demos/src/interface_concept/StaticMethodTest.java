package interface_concept;

public class StaticMethodTest {

    public static void main(String[] args) {
        Parent p = new Child();
        p.show();
    }
}


class Parent {
    public /*static*/ void show() {
        System.out.println("I am from the parent class");
    }
}

class Child extends Parent {
    public /*static*/ void show() {
        System.out.println("I am from the child class");
    }
}