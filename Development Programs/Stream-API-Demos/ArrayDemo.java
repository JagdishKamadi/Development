import java.util.stream.*;
import java.util.*;

class ArrayDemo
{
	public static void main(String []args)
	{
		// it give unmodifiable list
		List<Integer> list1 = Arrays.asList(1,2,4,6,7,8);
		// we cannot add now 
		// will generate UnsupportedOperationException
		// list1.add(6);
		System.out.println(list1);

		// it alos gives unmodifiable list
		List<Integer> list2 = List.of(1,2,3);
		// will generate error and throw UnsupportedOperationException
		// list2.add(56);
		System.out.println(list2);
		System.out.println("end");

	}
}