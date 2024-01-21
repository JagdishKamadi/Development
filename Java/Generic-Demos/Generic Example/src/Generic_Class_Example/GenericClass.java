package Generic_Class_Example;

//create a generics class
class GenericsClass<T> {

	// variable of T type
	private T data;

	public GenericsClass(T data) {
		this.data = data;
	}

	// method that return T type variable
	public T getData() {
		return this.data;
	}
}