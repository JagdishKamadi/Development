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

    	for(int i=0;i<haystackLen;i++){
    		int j=0;
    		int check=0;

    		if(needle.charAt(0) == haystack.charAt(i)){
    			check = i;
    			while((j<needleLen && i<haystackLen) && (needle.charAt(j) == haystack.charAt(i)))
    			{
    				i++;
    				j++;
    			}
    		}

    		

    		if(j==needleLen){
    			return check ;
    		}
    	}

    	return -1;
    }
}