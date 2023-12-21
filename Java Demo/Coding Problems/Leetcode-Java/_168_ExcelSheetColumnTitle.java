class _168_ExcelSheetColumnTitle{
	public static void main(String[] args) {
		System.out.println(new Solution().convertToTitle(28));
	}
}

class Solution {
		    public String convertToTitle(int columnNumber) {
        		String res="";

        		while(columnNumber>0){
        			int reminder = (columnNumber-1)%26;
        			res = (char)(reminder+'A')+res;
        			columnNumber=(columnNumber-1)/26;
        		}
        		return res;
    }
}