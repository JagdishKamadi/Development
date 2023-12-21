import java.util.*;
import java.util.stream.Stream;

class _58_LengthofLastWord{
	public static void main(String []args){

		String s = "Hello World";

		Solution solution = new Solution();
		System.out.println(solution.lengthOfLastWord(s));

	}
}

class Solution {
    public int lengthOfLastWord(String s) {
        String spiltString[]  = s.split(" ");
        return spiltString[spiltString.length-1].length();
    }
}