import java.util.*;


class _205_IsomorphicStrings{
	public static void main(String[] args) {
		
		String s = "egg";
		String t =  "add";

		Solution solution = new Solution();
		System.out.println(solution.isIsomorphic(s,t));
	}

}


class Solution {
    public boolean isIsomorphic(String s, String t) {

    	Map<Character,Character> map = new HashMap<>();

    	for(int i=0;i<s.length();i++){

    		if(!map.containsKey(s.charAt(i))){

    			if(map.containsValue(t.charAt(i))){
    				return false;
    			}

    			map.put(s.charAt(i),t.charAt(i));
    		} else if(map.get(s.charAt(i))!=t.charAt(i)){
    			return false;
    		}

    	}

    	return true;
        
    }
}