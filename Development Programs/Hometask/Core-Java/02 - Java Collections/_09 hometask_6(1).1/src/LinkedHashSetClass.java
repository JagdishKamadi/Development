import java.util.*;
public class LinkedHashSetClass {
    public static void main(String[] args) {
        // LinkedHashSet with default capacity and load factor
        LinkedHashSet<Integer> evenNumber = new LinkedHashSet<>();

        // Using add() method
        evenNumber.add(6);
        evenNumber.add(4);
        evenNumber.add(2);
        System.out.println("LinkedHashSet: " + evenNumber);

        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();

        // Using addAll() method
        numbers.addAll(evenNumber);
        numbers.add(5);
        System.out.println("New LinkedHashSet: " + numbers);

        // Calling the iterator() method
        Iterator<Integer> iterate = numbers.iterator();

        System.out.print("LinkedHashSet using Iterator: ");

        // Accessing elements
        while(iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }

        // Using the remove() method
        boolean value1 = numbers.remove(5);
        System.out.println("Is 5 removed? " + value1);

        LinkedHashSet<Integer> evenNumbers = new LinkedHashSet<>();
        evenNumbers.add(2);
        evenNumbers.add(4);
        System.out.println("LinkedHashSet1: " + evenNumbers);

        LinkedHashSet<Integer> numbers2 = new LinkedHashSet<>();
        numbers2.add(1);
        numbers2.add(3);
        System.out.println("LinkedHashSet2: " + numbers2);

        // Union of two set
        numbers2.addAll(evenNumbers);
        System.out.println("Union is: " + numbers2);

        LinkedHashSet<Integer> primeNumbers = new LinkedHashSet<>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        System.out.println("LinkedHashSet1: " + primeNumbers);

        LinkedHashSet<Integer> evenNumbers3 = new LinkedHashSet<>();
        evenNumbers3.add(2);
        evenNumbers3.add(4);
        System.out.println("LinkedHashSet2: " + evenNumbers3);

        // Intersection of two sets
        evenNumbers3.retainAll(primeNumbers);
        System.out.println("Intersection is: " + evenNumbers3);
    }
}
