import java.util.Optional;

class OptionalDemo4
{
	public static void main(String[] args)
	{
		String name = "Jagdish";
		Optional<String> opt = Optional.of(name);

		opt.ifPresent(val->System.out.println(opt));
		// or 
		opt.ifPresent(System.out::println);
		// some more operation
		opt.ifPresent(val->System.out.println(opt.get().toUpperCase()));
	}
}