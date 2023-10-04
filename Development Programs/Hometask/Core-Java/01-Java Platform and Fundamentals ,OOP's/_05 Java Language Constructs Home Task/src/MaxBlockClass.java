/* Problem Statement
 Given a string, return the length of the largest "block" in the string.
  A block is a run of adjacent chars that are the same.
 */

import java.util.Scanner;

public class MaxBlockClass {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in))
        {
            // receive input
            String str = sc.next();

            // to store the result
            int res = maxBlock(str);
            // to display the result
            System.out.println(res);
        }
    }
    public static  int maxBlock(String str) {
        int count=1;    // initially it should one
        int max=0;      // counting max
        str+="_";       // last character should now count

        for(int i=0;i<str.length()-1;i++)   // traverse the string
        {
            if(str.charAt(i)==str.charAt(i+1))  // compare weather next character and current character is matching or not
                count++;                        // if match then increase count++
            else
                count=1;                        // if not match then set count to one

            if(count>max)                       // if current count is max than max then update max
                max=count;                      // update max
        }
        return max;                             // return max
    }
}
