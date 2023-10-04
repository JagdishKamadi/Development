import java.util.*;

public class HashMapClass {
    public static void main(String[] args) {

        // create a hashmap
        HashMap<String, Integer> languages = new HashMap<>();

        // add elements to hashmap
        languages.put("Java", 8);
        languages.put("JavaScript", 1);
        languages.put("Python", 3);
        // it will print key-value in the random order
        System.out.println("HashMap: " + languages);

        // get() method to get value
        int value = languages.get("Java");
        System.out.println("Value at index 1: " + value);

        // return set view of keys
        // using keySet()
        System.out.println("Keys: " + languages.keySet());

        // return set view of values
        // using values()
        System.out.println("Values: " + languages.values());

        // return set view of key/value pairs
        // using entrySet()
        System.out.println("Key/Value mappings: " + languages.entrySet());

        // change element with key 2
        languages.replace("Python", 4);
        System.out.println("HashMap using replace(): " + languages);

        // remove element associated with key Java
        value = languages.remove("Java");
        System.out.println("Removed value: " + value);

        // iterate through keys only
        System.out.print("Keys: ");
        for (String key : languages.keySet()) {
            System.out.print(key);
            System.out.print(", ");
        }

        // iterate through values only
        System.out.print("\nValues: ");
        for (int val : languages.values()) {
            System.out.print(val);
            System.out.print(", ");
        }

        // using foreach loop
        languages.forEach((k,v)-> System.out.println("Key->"+k+" : value->"+v));
    }
}
