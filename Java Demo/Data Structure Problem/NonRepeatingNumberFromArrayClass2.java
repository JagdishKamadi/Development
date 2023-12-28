

/**
 * Here we have given the array which contain duplicate element
 * We have to find the element which comes exactly one
 */

class NonRepeatingNumberFromArrayClass2{
	public static void main(String[] args) {
		int [] arr = {1,5,6,7,6,1,5};
		System.out.println(getOneNumber(arr));
 	}

 	// we are using the XOR operation here
 	// remember the key point of XOR
 	// n ^ n = 0
 	// 0 ^ n = n

 	private static int getOneNumber(int [] arr){
 		int res = 0;

 		for(int i:arr){
 			res = res^i;
 		}

 		return res;
 	}
}