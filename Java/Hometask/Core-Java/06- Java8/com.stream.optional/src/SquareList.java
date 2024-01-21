/*  Problem Statement
    Given a list of numbers, how would you return a list of the square of each number? For
    example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].
 */

import java.util.*;
public class SquareList {
    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squareList = lst.stream()
                                      .map(i->i*i)
                                       .toList();

        System.out.println(squareList);
    }

}
