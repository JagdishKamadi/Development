class _389_FindTheDifference{
	public static void main(String[] args) {
		
	}
}

class Solution {
    public char findTheDifference(String s, String t) {
        char res=0;

        for(char ch:s.toCharArray()){
        	res^=ch;
        }

        for(char ch:t.toCharArray()){
        	res^=ch;
        }

        return res; 
    }
}