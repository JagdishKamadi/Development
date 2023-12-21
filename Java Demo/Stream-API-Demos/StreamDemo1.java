import java.util.*;
import java.util.stream.*;

class StreamDemo1{
	public static void main(String[] args) {
		
		String names[] = {"Jagdish","Madhur","Jayant"};
		Stream<String> stream1 = Arrays.stream(names);

		stream1.forEach(s->System.out.print(s+" "));
		System.out.println();

		Stream<String> stream2 = Stream.of(names); 

		stream2.forEach(System.out::print);
	}
}