import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
    public static void main(String[] args) {

        // Create an ArrayList object
        ArrayList<String> cars = new ArrayList<String>();

        // Add Items
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);

        // Access an Item
        System.out.println(cars.get(0));

        // Change an Item
        cars.set(0, "Opel");
        System.out.println(cars);

        // Remove an Item
        cars.remove(0);
        System.out.println(cars);
        // Clear all element
        // cars.clear();
        System.out.println(cars);

        // ArrayList Size
        System.out.println(cars.size());

        // Loop Through an ArrayList
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }

        // Sort an ArrayList
        Collections.sort(cars);
        System.out.println(cars);

        // Other types
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(10);
        myNumbers.add(15);
        myNumbers.add(20);
        myNumbers.add(25);
        for (int i : myNumbers) {
            System.out.println(i);
        }

    }
}
