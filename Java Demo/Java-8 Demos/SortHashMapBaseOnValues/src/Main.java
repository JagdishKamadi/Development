import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Main {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap();

		map.put(101, 45);
		map.put(102, 67);
		map.put(103, -1);
		map.put(105, 89);
		map.put(106, 4);
		map.put(107, 11);
		map.put(108, 0);

		Map<Integer, Integer> sorted = map.entrySet()
				.stream()
				.sorted(comparingByValue())
				.collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println(sorted);

		Map<Integer, Integer> sortedInReverseOrder = map.entrySet()
				.stream()
				.sorted(comparingByValue(Collections.reverseOrder()))
				.collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println(sortedInReverseOrder);
	}
}