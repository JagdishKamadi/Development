package Generic_Constructor_Example;

public class GenericConstructorTest {
	public static void main(String []args)
	{
		// Initialize GenericConstructor class
		GenericConstructor<Integer> g1 = new GenericConstructor(45,50,68);
		
		System.out.println("Generic Constructor Example 1 for Integer");
		System.out.println("Length -> "+g1.getLength()+" | Width -> "+g1.getWidth()+
				" | Height -> "+g1.getHeight());


		// Initialize GenericConstructor class
				GenericConstructor<Double> g2 = new GenericConstructor(45.0,50.0,68.0);
		
	   System.out.println("\nGeneric Constructor Example 2 for Double");
		System.out.println("Length -> "+g2.getLength()+" | Width -> "+g2.getWidth()+
				" | Height -> "+g2.getHeight());

		
				
	}

}
