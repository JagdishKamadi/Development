import java.util.*;


class _121_BestTimeToBuyAndSellStock{
	public static void main(String val[]){

	}
}


class Solution {
    public int maxProfit(int[] prices) {

    	int lsf = Integer.MAX_VALUE;
    	int finalProfit = 0;

    	for(int i=0;i<prices.length;i++){

    		if(prices[i]<lsf){
    			lsf = prices[i];
    		}

    		int diff = prices[i]-lsf;

    		if(diff>finalProfit){
    			finalProfit = diff;
    		}
    	}

    	return finalProfit;
    }
}