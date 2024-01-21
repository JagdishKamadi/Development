import java.util.*;

class ValidParentheses_20
{
	public static void main(String[] args) {
		String	s = "()[{";

		Solution solution = new Solution();

		System.out.println("Result : "+solution.isValid(s));
	}
}

class Solution {
    public boolean isValid(String s) {

        if(s.length()%2!=0){
        	return false;
        }

        Stack<Character> stack = new Stack<Character>();
        stack.push('$');

        for(int i=0;i<s.length();i++){

        	char ch = s.charAt(i);
        	
        	if(ch == '(' || ch == '{' || ch == '['){
        		stack.push(ch);
        	}else 
        	if((ch == ')' && stack.peek()=='(') || (ch == '}' && stack.peek()=='{') || (ch == ']' && stack.peek()=='[')) {
        		stack.pop();
        	}else{
        		return false;
        	}
        }

        return stack.size()==1;
    }
}