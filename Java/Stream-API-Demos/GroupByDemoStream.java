import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class GroupByDemoStream
{
	public static void main(String[] args) {
		List<Person> persons =
		Arrays.asList(
			new Person("Max", 18),
			new Person("Peter", 23),
			new Person("Pamela", 23),
			new Person("David", 12));

		Map<Integer,List<Person>> personByAge = persons.stream()
														.collect(Collectors.groupingBy(p->p.getAge()));

	    System.out.println(personByAge);

	}
}