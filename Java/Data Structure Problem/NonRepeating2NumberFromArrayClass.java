/*
	We have to find the 2 non repeating character from the given arry
*/

class NonRepeating2NumberFromArrayClass{
	public static void main(String[] args) {
		int [] arr = {5,4,1,4,3,5,1,2};

		// first find X-OR
		int xor = 0;

		for(int i:arr){
			xor = xor ^ i;
		}

		

		// now take out the odd number from one side
	}
}