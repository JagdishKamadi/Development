class _28_FindTheIndexOfTheFirstOccurrenceInAString{
	public static void main(String[] args) {
		
		String haystack = "sadbutsad", needle = "sad";

		Solution s = new Solution();
		System.out.println(s.strStr(haystack,needle));
	}
}


class Solution {
    public int strStr(String haystack, String needle) {

    	int needleLen = needle.length();
    	int haystackLen = haystack.length();

    	if(haystackLen<needleLen){
    		return -1;
    	}

    	for(int i=0;i<=haystackLen-needleLen;i++){
    		
    		int j=0;

    		while(j<needleLen && haystack.charAt(i+j)==needle.charAt(j)){
    			j++;
    		}

    		if(j==needleLen){
    			return i;
    		}
    	}

    	return -1;
    }
}