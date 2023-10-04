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
		
// we cannot apply terminal operation of one terminal operation is already there
class TerminalOperationDemo2
{
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(1,2,3,4,4,5,6,3,4,5,5,2,9);

		List<Integer> evenList = lst.stream().
										filter(TerminalOperationDemo2::getEven).
										collect(Collectors.toList());
		System.out.println(evenList);

		long count = lst.stream().
								filter(TerminalOperationDemo2::getEven).
								count();
		System.out.println(count);

		// distinct count
		count = lst.stream().distinct().count();
		System.out.println(count);


		lst.stream().
		filter(TerminalOperationDemo2::getEven).
		forEach(element->System.out.print(element));

	}


	static boolean getEven(int n)
	{
		return n%2==0;
	}
}