import java.util.*;

class _125_ValidPalindrome{
	public static void main(String[] args) {
		
		String s = "A man, a plan, a canal: Panama";

		Solution solution = new Solution();
		System.out.println(solution.isPalindrome(s)); 
	}

}

class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder();

        for(char ch:s.toCharArray()){

        	if(Character.isDigit(ch) || Character.isLetter(ch)){
        		sb.append(Character.toLowerCase(ch));
        	}
        }

        return sb.toString().equals(sb.reverse().toString());
    }
}