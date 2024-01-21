package org.epam.circulardependency;

public class A {
 public B b;

    public A(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }
}
