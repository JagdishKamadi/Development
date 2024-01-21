import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Here we have given the array which contain duplicate element
 * We have to find the element which comes exactly one
 */

class NonRepeatingNumberFromArrayClass{
	public static void main(String[] args) {
		
		int [] arr = {1,5,6,7,6,1,5};
		System.out.println(getOneNumber(arr));
 	}

// we are solving using the HashMap here
 	private static int getOneNumber(int[] arr){
		Map<Integer,Integer> map = new HashMap<>();

		for(int i:arr){
			map.put(i,map.getOrDefault(i,0)+1);
		}
	

		int res = map.keySet()
					.stream()
					.filter(key-> map.get(key)==1)
					.findFirst()
					.orElse(-1);

		return res;
 	}
}