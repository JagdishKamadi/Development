class _35_SearchInsertPosition{
	public static void main(String[] args) {
		
		int nums[] = {1,3,5,6}, target = 5;

		Solution s = new Solution();
		System.out.println(s.searchInsert(nums,target));
	}
}


class Solution {
    public int searchInsert(int[] nums, int target) {

    	int start = 0;
    	int end = nums.length-1;

    	while(start<=end){

    		int mid = start+(end-start)/2;;

    		if(nums[mid]==target){
    			return mid;
    		} 
    		else if(nums[mid] > target){
    			end = mid-1;
    		}
    		else{
    			start = mid+1;
    		}
    	} 
        return start;
    }
}