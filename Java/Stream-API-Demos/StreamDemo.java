
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class StreamDemo
{
	public static void main(String[] args) {
		 Stream.of("d2", "b5","a2", "b1", "b3", "c")
    .filter(s -> {
        System.out.println("filter: " + s);
        return s.startsWith("b");
    })
    .sorted()
    .forEach(System.out::print);

    
	}
}