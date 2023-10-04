/*
    we have to generic method to solve this problem
 */
public class Printer {
    // generic method which convert according to the object type
    public static <E> void printArray(E[] obj) {

        /* traveling each element in the array */
        for(E each:obj)
            System.out.print(each+" ");

        System.out.println();
    }
}