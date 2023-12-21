/*	Problem Statement
 Create code which displays in console â€œHello, NAMEâ€,
 where NAME is taken from Command line
 */

import java.util.*;
public class BasicClassTest1 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            // name to store user name
            String name = sc.next();
            // display the o/sp
            System.out.println("Hello, "+name);
        }
    }

}
