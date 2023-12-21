
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class SupplierDemoWithStream
{
	public static void main(String[] args) {

		/*
			Stream<String> stream =
	    	Stream.of("d2", "a2", "b1", "b3", "c")
	        .filter(s -> s.startsWith("a"));

			stream.anyMatch(s -> true);    // ok
			stream.noneMatch(s -> true);   // exception

		*/

		// to avoid above sceneraio we have to use supplier function interface  
		List<String> names = Arrays.asList("Jagdish","Kamadi","Mayur","Tejas","Jayany","Jay");

		Supplier<Stream<String>> sp = ()->names.stream().filter(element-> element.startsWith("J"));

		// now you cam perform number of operation
		sp.get().forEach(System.out::print);
		boolean res = sp.get().anyMatch(element->element.equalsIgnoreCase("jagdish"));
		System.out.println("\n"+res);
		
	}
}