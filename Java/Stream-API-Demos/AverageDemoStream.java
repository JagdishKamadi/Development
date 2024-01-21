import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class AverageDemoStream
{
	public static void main(String[] args) {
		List<Person> persons =
		Arrays.asList(
			new Person("Max", 18),
			new Person("Peter", 23),
			new Person("Pamela", 23),
			new Person("David", 12));

		Double avgAge = persons.stream().collect(Collectors.averagingInt(Person::getAge));
		System.out.println(avgAge);
	}
}