package Generic_Class_Example;

public class GenericClassTest {
	public static void main(String args[])
	{
		 // initialize generic class
	    // with Integer data
		System.out.println("Generic Class Example");
	    GenericsClass<Integer> intObj = new GenericsClass<>(5);
	    System.out.println("Generic Class returns: " + intObj.getData());

	    // initialize generic class
	    // with String data
	    GenericsClass<String> stringObj = new GenericsClass<>("Java Programming");
	    System.out.println("Generic Class returns: " + stringObj.getData());
	}

}
