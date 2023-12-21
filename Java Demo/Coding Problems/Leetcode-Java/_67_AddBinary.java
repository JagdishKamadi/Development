import java.util.*;

class _67_AddBinary{
	public static void main(String[] args) {
		
	}
}


class Solution {
public static String addBinary(String a, String b) {

    StringBuilder sb = new StringBuilder();

    int aLen = a.length()-1;
    int bLen = b.length()-1;

    int carry =0;

    while(aLen >=0 || bLen >=0 || carry!=0){
        int aSum = aLen >= 0 ? a.charAt(aLen)-'0' : 0;
        int bSum = bLen >= 0 ? b.charAt(bLen)-'0' : 0;

        int sum = aSum+bSum+carry;
        sb.insert(0,sum%2);
        carry = sum/2;

        aLen--;
        bLen--;

    }
    return sb.toString();
}
}