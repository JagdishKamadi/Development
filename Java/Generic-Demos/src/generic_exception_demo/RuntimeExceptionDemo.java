package generic_exception_demo;

import java.util.ArrayList;

// this is the best example of runtime exception in generic
public class RuntimeExceptionDemo {
    public static void main(String[] args) {
        ArrayList lst = new ArrayList();

        // compiler allow this
        lst.add("Jagdish");
        lst.add("Madhur");

        // compiler also allow this
        lst.add(12);

        System.out.println(lst.get(0) + " type" + lst.get(0).getClass());
        // also allow this
        System.out.println(lst.get(2) + " type" + lst.get(2).getClass());

        // below statement will create problem
        String s3 = (String)lst.get(2);
    }
}
