import java.util.LinkedList;

public class LinkedListClass {
    public static void main(String[] args) {

        // create linkedlist
        LinkedList<String> animals = new LinkedList<>();

        // Add elements to LinkedList
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Cow");
        System.out.println("LinkedList: " + animals);

        // add() method with the index parameter
        animals.add(1, "Horse");
        System.out.println("Updated LinkedList: " + animals);

        // get the element from the linked list
        String str = animals.get(1);
        System.out.print("Element at index 1: " + str);

        // change elements at index 3
        animals.set(3, "Cock");
        System.out.println("Updated LinkedList: " + animals);

        // remove elements from index 1
        str = animals.remove(1);
        System.out.println("Removed Element: " + str);

        // access the first element
        String str1 = animals.peek();
        System.out.println("Accessed Element: " + str1);

        // access and remove the first element
        String str2 = animals.poll();
        System.out.println("Removed Element: " + str2);
        System.out.println("LinkedList after poll(): " + animals);

        // add element at the
        animals.add("Cow");
        System.out.println("LinkedList: " + animals);

        // add elements at the end
        animals.addLast("Zebra");
        System.out.println("LinkedList after addLast(): " + animals);

        // remove the first element
        animals.removeFirst();
        System.out.println("LinkedList after removeFirst(): " + animals);

        // remove the last element
        animals.removeLast();
        System.out.println("LinkedList after removeLast(): " + animals);
    }
}
