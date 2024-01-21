import java.util.*;
import java.lang.Math.*;

class _171_ExcelSheetColumnNumber
{
	public static void main(String[] args) {
		
		Solution s = new Solution();
		System.out.println(s.titleToNumber("Q"));
	}
}

class Solution {
    public int titleToNumber(String columnTitle) {
        
        int sum = 0;
        double len = columnTitle.length()-1;

        for(char ch:columnTitle.toCharArray()){
        	int d = ch-'A'+1;
        	sum = (d*(int)Math.pow(26d,len))+sum;
        	len--;
        }
        return sum;
    }
}