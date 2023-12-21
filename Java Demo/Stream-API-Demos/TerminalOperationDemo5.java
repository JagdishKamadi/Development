import java.util.*;
import java.util.stream.*;
import java.util.function.*;


class TerminalOperationDemo5
{
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(1,2,3,3,3,4,4);
		long sum = lst.stream().reduce(0,(x,y)->(x+y));
		System.out.println(sum);

		int nums[] = {1,2,3};
		sum = Arrays.stream(nums).reduce(0,(x,y)->(x+y)*2);
		System.out.println(sum);

	}
}