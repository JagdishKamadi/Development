import java.util.*;
import java.lang.Math.*;

class _219_ContainsDuplicate_II{
	public static void main(String[] args) {
		
	}
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){

	if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i])-i)<=k){
			return true;
	}
	
		map.put(nums[i],i);
	
}
        

        return false;
    }
}