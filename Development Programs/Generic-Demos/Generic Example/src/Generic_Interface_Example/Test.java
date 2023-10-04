package Generic_Interface_Example;

//This generic class implement generic interface.
 class Test<T> implements GenericInterface1<T>  {
	public void show(T t)
	{
		System.out.println("I am from GenericInterface1 and my value is "+t);
	}
}
 
 class Test2<T1,T2> implements GenericInterface2<T1, T2> 
 {
	public void show(T1 t1,T2 t2)
	{
		System.out.println("I am from GenericInterface2 and my value is "+t1+" "+t2);
	}
		
 }