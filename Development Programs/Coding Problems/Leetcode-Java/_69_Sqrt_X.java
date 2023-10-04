import java.lang.Math.*;

class _69_Sqrt_X{
	public static void main(String[] args) {

		int x = 81;

		System.out.println(new Solution().mySqrt(x));
		
	}
}

class Solution {
    public int mySqrt(int x) {
        
  		if(x==0 || x==1){
  			return x;
  		}

  		int start=1;
  		int end = x;


  		while(start<=end){

  			int mid = start+(end-start)/2;

  			if ((long) mid * mid > (long) x)
                end = mid - 1;
            else if (mid * mid == x)
                // If the square of the middle value is equal to x, we found the square root.
                return mid;
            else
                // If the square of the middle value is less than x, move the "start" to the right (mid + 1).
                start = mid + 1;
  		}

  		return Math.round(end);
    }
}