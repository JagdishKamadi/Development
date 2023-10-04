package Generic_Method_Example;

public class GenericMethodTest {

	public static void main(String[] args) {
		
		// intilize class GenericMethod
		  GenericMethod genericMethod = new GenericMethod();
		 
		  System.out.println("Generic Method Example");
		 
		// Create arrays of Integer, Double and Character
	      Integer[] intArray = { 1, 2, 3, 4, 5 };
	      Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
	      Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

	      System.out.println("Array integerArray contains:");
	      genericMethod.printArray(intArray);   // pass an Integer array

	      System.out.println("\nArray doubleArray contains:");
	      genericMethod.printArray(doubleArray);   // pass a Double array

	      System.out.println("\nArray characterArray contains:");
	      genericMethod.printArray(charArray);   // pass a Character array

	}

}
