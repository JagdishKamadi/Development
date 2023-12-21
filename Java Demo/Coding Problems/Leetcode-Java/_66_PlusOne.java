import java.util.*;


class _66_PlusOne
{
	public static void main(String[] args) {
		int digits[] = {1,2,9};

		Solution s = new Solution();
		int op[] = s.plusOne(digits);
		

		for(int i:op){
			System.out.print(i+" ");
		}


	}
}

class Solution {
    public int[] plusOne(int[] digits) {
        
        int len = digits.length;
   		for(int i=len-1;i>=0;i--){
   			if(digits[i] == 9){
   				digits[i] = 0;
   			} else{
   				digits[i]++;
   				return digits;
   			}
   		}

   		int op[] = new int[len+1];
   		op[0] = 1;

   		return op;
    }

}