/*  Problem Statement
Let's say you have an integer array and a string array. You have to write a single method printArray that can print all the elements of both arrays. The method should be able to accept both integer arrays and string arrays.
Without using overloading complete the above code so that it prints all input arrays
 */
public class  Solution{

    public static void main(String args[]) {

        // create arrays of Integer, Double and Character

        Integer[] integerArray = {1, 2, 3, 4, 5, 6};

        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};

        Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.println("Array integerArray contains:");

        Printer.printArray(integerArray); // pass an Integer array

        System.out.println("\nArray doubleArray contains:");

        Printer.printArray(doubleArray); // pass a Double array

        System.out.println("\nArray characterArray contains:");

        Printer.printArray(characterArray); // pass a Character array

    }

}
