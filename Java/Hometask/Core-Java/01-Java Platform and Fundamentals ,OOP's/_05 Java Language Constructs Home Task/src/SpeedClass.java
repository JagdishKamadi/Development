/*  Problem Statement
  You are driving a little too fast, and a police officer stops you.
  Write code to compute the result, encoded as an int value: 0=no ticket,c
  1=small ticket, 2=big ticket. If speed is 60 or less,
  the result is 0. If speed is between 61 and 80 inclusive,
  the result is 1. If speed is 81 or more, the result is 2.
  Unless it is your birthday -- on that day, your speed can be 5 higher in all cases.
 */
import java.util.*;
public class SpeedClass {
    public static  void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) {
            // to receive speed as input
            int speed = sc.nextInt();
            // to receive birthday value as boolean
            boolean isBirthday = sc.nextBoolean();

            // storing the result
            int result = caughtSpeeding(speed,isBirthday);

            // display the result
            System.out.println(result);
        }
    }

    // this method calculate the result on the basis of speed and birthday
    public static int caughtSpeeding(int speed, boolean isBirthday) {
        // if isBirthday is false
        if(!isBirthday)
        {
            if(speed<=60)
                return 0;
            else if (speed>=61 && speed<=80)
                return 1;
            else if(speed>=81)
                return 2;
        }
        // if isBirthday is true
        // we have to increase the speed by 5 in all cases
        else
        {
            if(speed<=65)
                return 0;
            else if (speed>=66 && speed<=85)
                return 1;
            else if(speed>=86)
                return 2;
        }

        return 0;
    }

}
