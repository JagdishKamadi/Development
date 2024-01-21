import java.util.function.*;
import java.util.Optional;

class OptionalFilterDemo 
{
	public static void main(String[] args) throws Exception{
		Optional opt1 = Optional.ofNullable("I am honest");
		Optional opt2 = Optional.empty();

		// filter map takes predicate interface
		Predicate<String> pred = (s)-> s.contains("am");

		System.out.println(opt1.filter(pred)); // true-> return value
		System.out.println(opt2.filter(pred)); // false-> return empty()
	}
}