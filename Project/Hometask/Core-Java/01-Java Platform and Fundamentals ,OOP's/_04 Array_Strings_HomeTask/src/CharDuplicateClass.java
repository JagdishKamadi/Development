/* Problem Statement
write a program to Print duplicate characters from String
 */

import java.util.*;

public class CharDuplicateClass {

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in))
        {
            String str = sc.next();  			// receiving string as input
            findDuplicate(str);	// calling findDuplicate method from StringOperation class
        }


    }

    // method which print duplicate from string
    public static void findDuplicate(String str)
    {
        // HashMap to store the occurrence of each character
        Map<Character,Integer> map = new HashMap<Character,Integer>();

        for(int i=0;i<str.length();i++)			// traveling string
        {
            char ch = str.charAt(i);			// convert into the character

            if(map.containsKey(ch))				// check weather character already present or not
            {
                int count = map.getOrDefault(ch, 0);	/* if present then get value else default value will set to 0 */
                map.put(ch,count+1);					// updating key value
            }
            else
            {
                map.put(ch, 1);					// if it is first time then update key with initial value with 1
            }
        }

        Iterator<Character> it = map.keySet().iterator();	// iterating HashMap

        while(it.hasNext())						// iterate till last element
        {
            char key = it.next();				// getting key
            int value = map.get(key);			// getting key value

            if(value>1)							// if key occurrence present more than 1, then print key
                System.out.print(key+" ");
        }

    }

}

