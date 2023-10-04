/*  Problem Statement
We are having a party with amounts of tea and candy.
Return the int outcome of the party encoded as 0=bad, 1=good, or 2=great.
 A party is good (1) if both tea and candy are at least 5. However,
 if either tea or candy is at least double the amount of the other one,
 the party is great (2). However, in all cases,
if either tea or candy is less than 5, the party is always bad (0).
 */

import java.util.Scanner;

public class TeaPartyClass {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in))
        {
            // receive tea value
            int tea = sc.nextInt();
            // receive candy value
            int candy = sc.nextInt();

            // to store the result
            int result = teaCandyParty(tea,candy);
            // display the result
            System.out.println(result);
        }
    }

    // returning the outcome of the tea candy party
    public static int teaCandyParty(int tea, int candy) {

        // case for bad party
        if(tea<5 || candy<5)
            return 0;
        // case for great party
        else if((tea>=(candy*2)) || (candy>=(tea*2)))
            return 2;
        else
            return 1;  // it will become good party
    }

}

