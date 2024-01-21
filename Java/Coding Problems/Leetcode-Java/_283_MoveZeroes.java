class _283_MoveZeroes
{
	public static void main(String[] args) {
		
	}
}

class Solution {
    public void moveZeroes(int[] nums) {
        int count=0;
        

        for(int val:nums){
        	if(val!=0){
        		nums[count] = val;
        		count++;
        	}
        }

      while(count<nums.length){
      	nums[count]=0;
      	count++;
      }
}
}