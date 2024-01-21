class TrailingZeroesInFactorialClass{

	public static void main(String[] args) {
		System.out.println(trailingZeroes(20));
	}

	static int trailingZeroes(int N){
       int res = 0;
       
       for(int i=5;i<=N;i=i*5){
           res = res + N/i;
       }
       return res;
    }
}
