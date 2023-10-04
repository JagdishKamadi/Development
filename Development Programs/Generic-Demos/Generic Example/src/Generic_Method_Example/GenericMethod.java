package Generic_Method_Example;

public class GenericMethod {
	// generic method printArray
	   public  <E> void printArray( E[] inputArray ) {

	      // Display array elements
	      for(E element : inputArray) {
	         System.out.print(element+" ");
	      }

	      System.out.println();
	   }

}
