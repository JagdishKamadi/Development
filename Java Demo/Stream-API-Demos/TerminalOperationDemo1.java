import java.util.*;
import java.util.stream.*;
import java.util.function.*;

	/* Terminal operation list
	 	1. The allMatch() operation
		2. The anyMatch() operation
		3. The noneMatch() operation
		4. The collect() operation
		5. The count() operation
		6. The forEach() operation
		7. The min() operation
		8. The max() operation
		9. The reduce() operation
	 */

class TerminalOperationDemo1
{
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(1,2,3,4,2,3,4,5,7,8);

		// So, the distinct() method represents an intermediate operation, 
		// which creates a new stream of unique elements of the previous stream. 
		// And the count() method is a terminal operation, which returns stream's size.
		long count = lst.stream().distinct().count();
		System.out.println(count);


		boolean res1 = lst.stream().anyMatch(element -> element==2);
		System.out.println(res1);
	    res1 = lst.stream().anyMatch(element -> element==6);
		System.out.println(res1);

		res1 = lst.stream().allMatch(element-> element<10);	
		System.out.println(res1);
		res1 = lst.stream().allMatch(element-> element>10);	
		System.out.println(res1);		

		// noneMatch != allMatch()
		res1 = lst.stream().noneMatch(element-> element>10); // return true
		System.out.println(res1);	
	}
}