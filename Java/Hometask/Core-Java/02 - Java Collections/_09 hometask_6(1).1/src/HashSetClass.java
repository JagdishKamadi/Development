import java.util.*;
public class HashSetClass {
    public static void main(String[] args) {

        // create  HashSet object
        HashSet<Integer> evenNumber = new HashSet<>();

        // Using add() method
        evenNumber.add(2);
        evenNumber.add(4);
        evenNumber.add(6);
        System.out.println("HashSet: " + evenNumber);

        HashSet<Integer> numbers = new HashSet<>();

        // Using addAll() method
        numbers.addAll(evenNumber);
        numbers.add(5);
        System.out.println("New HashSet: " + numbers);

        // Calling iterator() method
        Iterator<Integer> iterate = numbers.iterator();
        System.out.print("HashSet using Iterator: ");
        // Accessing elements
        while(iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }

        // Using remove() method
        boolean value1 = numbers.remove(5);
        System.out.println("Is 5 removed? " + value1);

        boolean value2 = numbers.removeAll(numbers);
        System.out.println("Are all elements removed? " + value2);

        HashSet<Integer> evenNumbers = new HashSet<>();
        evenNumbers.add(2);
        evenNumbers.add(4);
        System.out.println("HashSet1: " + evenNumbers);

        HashSet<Integer> number2 = new HashSet<>();
        number2.add(1);
        number2.add(3);
        System.out.println("HashSet2: " + number2);

        // Union of two set
        number2.addAll(evenNumbers);
        System.out.println("Union is: " + number2);

        HashSet<Integer> primeNumbers = new HashSet<>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        System.out.println("HashSet1: " + primeNumbers);

        HashSet<Integer> evenNumbers2 = new HashSet<>();
        evenNumbers2.add(2);
        evenNumbers2.add(4);
        System.out.println("HashSet2: " + evenNumbers2);

        // Intersection of two sets
        evenNumbers2.retainAll(primeNumbers);
        System.out.println("Intersection is: " + evenNumbers2);

    }
}
