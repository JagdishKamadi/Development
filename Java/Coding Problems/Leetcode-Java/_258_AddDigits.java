class _258_AddDigits{
	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.addDigits(11));
		
	}
}

class Solution {
    public int addDigits(int num) {
    	int sum=0;

    	while(num>0){
    		sum +=(num%10);
    		num/=10;
    	}

    	if(sum<10){
    		return sum;
    	}

    	return addDigits(sum); 
        
    }
}