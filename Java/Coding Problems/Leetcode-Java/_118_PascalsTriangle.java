import java.util.*;

class _118_PascalsTriangle{

	public static void main(String[] args) {
		
		Solution s = new Solution();
		System.out.println(s.generate(8));
	}
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
    	List<List<Integer>> lst = new ArrayList();

        if(numRows==0){
        	return lst;
        }
        

       	List<Integer> firstRow = new ArrayList<>();
       	firstRow.add(1);
        lst.add(firstRow);
       

        for(int i=1;i<numRows;i++){
        	
        	List<Integer> res = new ArrayList<>();
        	res.add(1);

        	for(int j=1;j<i;j++){
           		res.add(lst.get(i-1).get(j-1)+lst.get(i-1).get(j));
        	}

        	res.add(1);
        	lst.add(res);
        }

        return lst;
    }
}