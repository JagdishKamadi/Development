	import java.util.Optional;

	class OptionalDemo3{

		public static final String ANSI_YELLOW = "\033[0;32m";

		public static void main(String[] args) {

			System.out.println(getName("Jagadish"));
		}

		public static String getName(String name)
		{
			Optional<String> optionalValue = Optional.empty();
			
			if("Jagdish".equalsIgnoreCase(name))
			{
				optionalValue = Optional.ofNullable(name);
			}

			return optionalValue.orElse("I am blank now").toString();
		}
	}