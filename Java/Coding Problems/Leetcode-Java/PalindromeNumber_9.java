
public class PalindromeNumber_9{
	public static void main(String[] args) {

		int  val = 121;

		Solution Solution = new Solution();
		System.out.println(Solution.isPalindrome(val));
	}
}

class Solution {
    public boolean isPalindrome(int x) {
      
       if(String.valueOf(x).charAt(0)=='-'){
       	return false;
       }

       int real = x;
       int result = 0;

       while(x>0){
       	result = (result*10)+(x%10);
       	x/=10;
       }

      return real==result;
    }
}