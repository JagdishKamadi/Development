class _263_UglyNumber{
	public static void main(String[] args) {
		System.out.println(new Solution().isUgly(5));
	}
}

class Solution {
    public boolean isUgly(int n) {
        
        if(n<1){
        	return false;
        }

        int primeNumbers[] = {2,3,5};

        for(int prime:primeNumbers){

        	while(n%prime==0){
        		n/=prime;
        	}
        }


        return n==1;
    }
}