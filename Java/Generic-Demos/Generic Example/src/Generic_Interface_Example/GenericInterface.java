package Generic_Interface_Example;

//GenericInterface1 generic interface.
interface GenericInterface1 <T> 
{
	// Declare an abstract method with parameter t of type T.
    public void show(T t);	
}

//GenericInterface2 generic interface.
interface GenericInterface2 <T1,T2> 
{
	// Declare an abstract method with parameter t1 of type T and t2 of type T2.
    public void show(T1 t1,T2 t2);	
}



