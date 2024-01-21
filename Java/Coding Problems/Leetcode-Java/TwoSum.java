import java.util.*;
import java.lang.Math.*;

class TwoSum{
	public static void main(String[] args) {
		int arr[] = new int[]{2,7,11,15};
		int target = 9;

		int result[] = new Solution().twoSum(arr,target);
		System.out.println(result[0]+" "+result[1]); 
	}
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){

        	if(map.containsKey(target-nums[i])){
        		return new int[] {map.get(target-nums[i]),i};
        	}

        	map.put(nums[i],i);
        }
        return new int[]{};
    }
}