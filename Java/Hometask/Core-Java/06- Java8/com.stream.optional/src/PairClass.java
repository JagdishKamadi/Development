/*
Given two lists of numbers, how would you return all pairs of numbers?

For example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)].
For simplicity, you can represent a pair as an array with two elements.

List<Integer> numbers1 = Arrays.asList(1,2,3);
List<Integer> numbers2 = Arrays.asList(3,4);
 */

import java.util.*;
import java.util.stream.Stream;

public class PairClass {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(3,4);

        Stream<Integer> stream1 = list1.stream();

        List<int[]> pairList = list1.stream()
                .flatMap(i->list2.stream()
                        .map(j->new int[]{i,j}))
                .toList();


        for(int pair[]:pairList)
        {
            System.out.print("[");
            for(int i=0;i<pair.length-1;i++)
            {
                System.out.print(pair[i]+",");
            }
            System.out.print(pair[pair.length-1]+"]\n");
        }
    }
}
