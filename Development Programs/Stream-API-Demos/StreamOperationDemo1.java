import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class StreamOperationDemo1
{
	public static void main(String[] args) {
		Arrays.asList("a1", "a2", "a3")
		.stream()
		.findFirst()
		.map(String::toUpperCase)
	    .ifPresent(System.out::println);  // a1


	    IntStream.range(1,5).forEach(System.out::print);
	    System.out.println();
	    IntStream.rangeClosed(1,5).forEach(System.out::print);

	    System.out.println();
	    int arr[] = {1, 2, 3};
	    Arrays.stream(arr)
	    .average()
	    .ifPresent(System.out::println);  // 5.0

	     System.out.println();
	     List<String> lst = Arrays.asList("a1","a2","b3");

	     // String to integer
	     lst.stream()
	     	.map(element->element.substring(1))
	     	.mapToInt(Integer::parseInt)
	     	.max()
	     	.ifPresent(element->System.out.println(element));

	   
	   // Integer to obj
	     List<String> objList = IntStream.range(1,4)
							     			.mapToObj(i->"A"+i)
							     			.collect(Collectors.toList());

	     System.out.println(objList);
	}
}