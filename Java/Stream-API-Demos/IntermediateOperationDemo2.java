import java.util.*;
import java.util.stream.*;
import java.util.function.*;

	/* below are Intermediate list
		filter()
		map()
		flatMap()
		distinct()
		sorted()
		peek()
		limit()
		skip(
	*/

class IntermediateOperationDemo2
{
	public static void main(String[] args) {
		 // Custom entries in the list elements
      List<Integer> intList = List.of(15,20,48,63,20,9,49,27,56,32,9);

      intList.stream()
            .map(element -> element * element * element)
            .forEach(
                element -> System.out.print(element + " "));
 
        // Display message only
        System.out.println(
            "\n\nOutput after distinct() implementation : ");
 
        // Applying distinct() on this
        intList.stream()
            .distinct()
            .map(element -> element * element * element)
            .forEach(
                element -> System.out.print(element + " "));
 
        // Display message only
        System.out.println(
            "\n\nOutput after sorted() implementation : ");
 
        // Now applying sorted() on this
        intList.stream()
            .distinct()
            .sorted()
            .map(element -> element * element * element)
            .forEach(
                element -> System.out.print(element + " "));
 
        // Display message only
        System.out.println(
            "\n\nOutput after filter() implementation : ");
 
        // Applying Filter() that values
        // only below 10000 will be printed
        intList.stream()
            .distinct()
            .sorted()
            .map(element -> element * element * element)
            .filter(element -> element < 10000)
            .forEach(
                element -> System.out.print(element + " "));
	}
}