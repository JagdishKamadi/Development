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

class IntermediateOperationDemo1
{
	public static void main(String[] args) {
		 // Custom entries in the list elements
      List<Integer> intList = List.of(15,20,48,63,20,9,49,27,56,32,9);
      intList.stream().
      				filter( element -> (element%2==0)).
      				forEach( element -> System.out.print(element+ " "));


      System.out.println();
      intList.stream().
      				sorted().
      				forEach( element -> System.out.print(element+ " "));

      List<Integer> newList = intList.stream().
						      				  distinct().
						      				  collect(Collectors.toList());
	  System.out.println(newList);

	}
}