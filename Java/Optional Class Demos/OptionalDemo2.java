// remember package name carefully
import java.util.Optional;

class OptionalDemo2
{
public static void main(String[] args) {
	String name = "My name is Jagdish";

	Optional<String> opt1 = Optional.of(name);

	System.out.println(opt1.map(n->n.toUpperCase()).orElse("I am empty boss!"));
	// using method referncing
	System.out.println(opt1.map(String::toUpperCase).orElse("I am not empty!"));

	// for empty()

	Optional<String> opt2 = Optional.empty();

	System.out.println(opt2.map(String::toUpperCase).orElse("I am empty now"));
	
}
}