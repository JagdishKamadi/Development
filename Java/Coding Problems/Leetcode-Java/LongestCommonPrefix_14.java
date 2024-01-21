import java.util.*;

class  LongestCommonPrefix_14{
	public static void main(String[] args) {
		String strs [] =  {"flower","flow","flight"};

		Solution solution = new Solution();
		System.out.println(solution.longestCommonPrefix(strs));
	}
}



class Solution {
    public String longestCommonPrefix(String[] strs) {
    	Arrays.sort(strs);
    	String start = strs[0];
    	String end = strs[strs.length-1];
    	int index = 0;

    	while(index<start.length() && index<end.length()){

    		if(start.charAt(index) == end.charAt(index)){
    			index++;
    		}else{
    			break;
    		}
    	}
    	return start.substring(0,index);
    }
}