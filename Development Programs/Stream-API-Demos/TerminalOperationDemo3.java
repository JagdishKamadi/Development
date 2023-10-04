import java.util.*;
import java.util.stream.*;
import java.util.function.*;


class TerminalOperationDemo3
{
	public static void main(String[] args) {
		List<String> items = Arrays.asList("apple", "apple", "banana",
											"apple", "orange", "banana", "papaya");

		TreeSet<String> itemsSet = items.stream().collect(Collectors.toCollection(TreeSet::new));
		System.out.println(itemsSet);


		// now we group together
		Map<String,Long> itemGroup = items.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(itemGroup);
	}
}