import java.util.Optional;
public class OptionalOfNullableDemo {
  public static void main(String[] args) {

    /*
     * ofNullable() - Returns an Optional describing the specified value, if
     * non-null, otherwise returns an empty Optional.
     */
    /*----------------------------------------------------------*/
    Optional nonEmptyOptional = Optional.ofNullable("Peter Milanovich");
    Optional emptyOptional = Optional.ofNullable(null);
    System.out.println(nonEmptyOptional);// Optional[Peter Milanovich]
    System.out.println(emptyOptional);// Optional.empty

  }
}