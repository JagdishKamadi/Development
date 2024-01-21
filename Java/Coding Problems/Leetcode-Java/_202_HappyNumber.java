class _202_HappyNumber{
	public static void main(String[] args) {

	System.out.println(new Solution().isHappy(2));

	}
}

class Solution {
    public boolean isHappy(int n) {
    	int count=0;
    	boolean flag = false;
    	int sum=0;
    	int nextNumber=n;


    	while(count<10){

    		while(nextNumber>0){
    			sum+=(nextNumber%10)*(nextNumber%10);
    			nextNumber/=10;
    		}

    		if(sum==1){
    			flag=true;
    			break;
    		}
    		count++;
    		nextNumber = sum;
    		sum=0;
    	}
        return flag;
    }
}