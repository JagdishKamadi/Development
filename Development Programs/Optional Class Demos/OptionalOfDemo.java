import java.util.Optional;
class OptionalOfDemo
{
	public static void main(String[] args) {
		// of() - returns a non-empty Optional with value
    /*-------------------------------------------------------*/
    Optional nonEmptyOptional = Optional.of("Peter");
    System.out.println(nonEmptyOptional);// Optional[Peter]
    System.out.println(Optional.of(null)); //NPE
	}
} 