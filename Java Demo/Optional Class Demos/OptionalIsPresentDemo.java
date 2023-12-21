import java.util.*;
import java.util.function.*;

class OptionalIsPresentDemo 
{
	public static void main(String[] args) {
		/**
		 * ifPresent method takes consumer interface
		 * so we need to implement it first
		 */

		Consumer<String> cons = (s)->System.out.println(s);
		Optional<String> opt = Optional.ofNullable("Jagdish");

		opt.ifPresent(cons);


		Optional<String> opt2 = Optional.ofNullable(null);
		// never invoked
		opt2.ifPresent(cons);
		System.out.println("I am not invoking");



	}
}