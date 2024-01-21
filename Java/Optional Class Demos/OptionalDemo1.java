import java.util.Optional;
import java.util.*;
class OptionalDemo1
{
public static void main(String[] args) {
	Optional<Object> opt = Optional.empty();

	// print true or false
	System.out.println(opt.isPresent());
	System.out.println(opt.isEmpty());
	System.out.println(opt.orElse("I am empty boss!"));

     List<String> lst2 = null;
     Optional<List<String>> stringList = Optional.ofNullable(lst2);

     if(stringList.isPresent())
     {
     	System.out.println("I am isPresent");
     }


	String name = "Jagdish";
	Optional<String> opt2 = Optional.ofNullable(name);

	// check now for opt2
	System.out.println();

	System.out.println(opt2.isEmpty());
	System.out.println(opt2.isPresent());
	System.out.println(opt2.orElse("I am empty boss! opt2"));

}
}