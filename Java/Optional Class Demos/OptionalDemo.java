import java.util.Optional;
import java.util.function.Predicate;
import java.util.*;

public class OptionalDemo
{
	public static void main(String[] args) {

	Optional<List<Integer>> opt = Optional.of(Arrays.asList(1,2,3,4));;

	Predicate<Integer> pred = new Predicate<Integer>()
	{
		public boolean test(Integer num)
		{
			return num%2==0;
		}
	};

	opt.get().stream().filter(pred).forEach(System.out::println);
	System.out.println("-------+ Working +-------");
	}
}

