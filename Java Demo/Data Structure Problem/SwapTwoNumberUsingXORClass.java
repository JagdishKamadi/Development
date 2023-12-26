class SwapTwoNumberUsingXORClass{

	public static void main(String[] val){
		int a = 5;
		int b = 6;

System.out.println("Before swaping");
System.out.printf("a = %d , b = %d",a,b);

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println("\nAfter swaping");
		System.out.printf("a = %d , b = %d",a,b);
	}
}