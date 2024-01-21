class _70_ClimbingStairs{
	public static void main(String[] args) {
		System.out.println(new Solution().climbStairs(12));
	}
}

class Solution {
    public int climbStairs(int n) {
        int f=0;
        int s=1;
        int t=0;
        int i=0;
        while(i<n){
            t = f+s;
            f=s;
            s=t;
            i++;
        }
        return t;
    }
}