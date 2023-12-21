import java.util.Optional;
import java.util.function.Function;

public class OptionalMapDemo {
  public static void main(String[] args) {

    Optional<String> opt1 = Optional.of("Jagdish Kamadi");
    Optional<String> opt2 = Optional.empty();

    /*
     * map() - If a value is present, apply the provided mapping function to it, and
     * if the result is non-null, return an Optional describing the result.
     * Otherwise return an empty Optional.
     */
      Function<String,String> fun = s -> s.toUpperCase();
      // or using method referncing
      Function<String,String> fun2 = String::toUpperCase;



     System.out.println( opt1.map(fun).get());
     System.out.println( opt2.map(fun2));
     System.out.println( opt1.map(fun2));

  }
}