import java.util.*;
import java.util.stream.*;
import java.util.function.*;

// There are two ways we can create which are listed below and described later as follows:

// Using parallel() method on a stream
// Using parallelStream() on a Collection 



class ParallelDemo
{
	public static void main(String[] args) {

		// using parallel stream 
		List<String> names = Arrays.asList("Jagdish","Madhur","Jayant","Harshal","Tejas","Kunal");
		// you can see every time output is different
		names.stream().parallel().forEach(System.out::print);
		System.out.println();

		// using parallerStream()
		Consumer<String> cons = element-> System.out.print(element+" ");
		names.parallelStream().forEach(cons);

		
	}
}