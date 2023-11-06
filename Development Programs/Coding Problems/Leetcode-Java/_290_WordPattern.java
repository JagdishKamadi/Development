import java.util.*;

class _290_WordPattern
{
	public static void main(String[] args) {
		
	}
}

class Solution {
    public boolean wordPattern(String pattern, String s) {

   		String[] words = s.split(" ");

   		if(words.length!=pattern.length())
   		{
   			return false;
   		}
        
        Map<Character,String> charToWord = new HashMap<>();
        Map<String,Character> wordToChar = new HashMap<>();

        for(int i=0;i<pattern.length();i++){
        	char ch = pattern.charAt(i);
        	String word = words[i];

        	if(!charToWord.containsKey(ch)){
        		charToWord.put(ch,word);
        	}

        	if(!wordToChar.containsKey(word)){
        		wordToChar.put(word,ch);
        	}

if (!charToWord.get(ch).equals(word) || !wordToChar.get(word).equals(ch)) {
                return false;
            }

        }
        return true;

    }
}