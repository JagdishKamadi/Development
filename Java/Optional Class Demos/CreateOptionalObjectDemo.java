import java.util.Optional;

public class CreateOptionalObjectDemo {
  public static void main(String[] args) {

    /*
     * Optional.empty() returns an empty Optional.
     */
    Optional emptyOptional = Optional.empty();

    /*
     * Optional.of("Peter") returns non empty Optional.
     * If value is null, will get NPE
     */
    Optional nonEmptyOptional = Optional.of("Peter");

    /*
     * Optional.ofNullable("Peter") returns non empty Optional.
     * If value is null, will get Optional.empty()
     */
    Optional nonEmptyOrEmptyOptional1 = Optional.ofNullable("Peter");
    
    Optional nonEmptyOrEmptyOptional2 = Optional.ofNullable(null);
    
    System.out.println(emptyOptional);
    System.out.println(nonEmptyOptional);
    System.out.println(nonEmptyOrEmptyOptional1);
    System.out.println(nonEmptyOrEmptyOptional2);
  }
}