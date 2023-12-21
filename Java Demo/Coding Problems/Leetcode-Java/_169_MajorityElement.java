import java.util.*;

class _169_MajorityElement
{
	public static void main(String[] args) {
		
		int nums[] = {1,2,1};
		Solution solution = new Solution();
		System.out.println(solution.majorityElement(nums));
	}
}

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        
        return nums[nums.length/2];
    }
}