package generic_exception_demo;

import java.util.ArrayList;

public interface CompiletimeExceptionDemo {
    public static void main(String[] args) {

        ArrayList<String> lst = new ArrayList<>();

        // valid
        lst.add("Jagdish");
        lst.add("Madhur");

        // now compiler not allow this
        // we itself declare type of data
        // IntelliJ showing red color that means compile time exception
        lst.add(12);
    }
}

