package Generic_Interface_Example;

public class GenericInterfaceTest {

	public static void main(String[] args) {
		
		// Initialize Test class
		Test<Integer> obj1 = new Test();
		System.out.println("Test Class Example");
		// class show method which takes one parameter
         obj1.show(822);
		
		System.out.println();
		
		
		// Initialize Test2 class
		Test2<String,Boolean> obj2 = new Test2();
		System.out.println("Test2 Class Example");
		// class show method which takes one parameter
	    obj2.show("Jagdish",true);
				

	}

}
