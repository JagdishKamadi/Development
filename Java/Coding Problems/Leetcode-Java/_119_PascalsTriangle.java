import java.util.*;

class _119_PascalsTriangle{
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.getRow(3));
	}
}

class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        if(rowIndex==0){
        	return firstRow;
        }

        for(int i=1;i<=rowIndex;i++){
        	List<Integer> temp = new ArrayList<>();
        	temp.add(1);

        	for(int j=1;j<i;j++){
        		temp.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
        	}

        	temp.add(1);
        	res.add(temp);
        }

        System.out.println(res);
        return res.get(rowIndex);
    }
}