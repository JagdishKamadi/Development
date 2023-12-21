import java.util.*;
import java.util.stream.*;
import java.util.function.*;


class TerminalOperationDemo4
{
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(1,2,3,4,56,4,5,6,3,4,5,5,2,9,-1);


		Comparator<Integer> comp = new Comparator<Integer>()
		{
			public int compare(Integer x,Integer y)
			{
				return x-y;
			}
		};

		Comparator<Integer> comp2 = (x,y) -> x-y;

		// find min
		int min = lst.stream().min((x,y) -> x-y).get();
		System.out.println(min);

		int max  = lst.stream().max(comp).get();
		System.out.println(max);
		max  = lst.stream().max(comp2).get();
		System.out.println(max);
	}
}