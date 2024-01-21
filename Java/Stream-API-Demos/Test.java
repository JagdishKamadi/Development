import java.util.function.*;
import java.util.*;
import java.util.stream.*;
import static System.out.*;
public class Test{
	
	public static void main(String[] args) {
		
		System.out.println(sum(10,12,12));
	}

	public static int sum(int... args)
	{
		int total=0;
		for(int i=0;i<args.length;i++)
		{
			total+=args[i];
		}
		return total;
	}
}