class RemoveDuplicatesFromSortedArray_26
{
	public static void main(String[] args) {
		
		int nums[] = new int[] { 1,1,2};

		Solution solution = new Solution();
		int count = solution.removeDuplicates(nums);

		for(int i=0;i<count;i++){
			System.out.print(nums[i]+" ");
		}

	}
}

class Solution {
    public int removeDuplicates(int[] nums) {
    	int count=1;

    	for(int i=1;i<nums.length;i++){

    		if(nums[i]!=nums[i-1]){
    			nums[count] = nums[i];
    			count++;
    		}
    	}

    	return count;
    }
}