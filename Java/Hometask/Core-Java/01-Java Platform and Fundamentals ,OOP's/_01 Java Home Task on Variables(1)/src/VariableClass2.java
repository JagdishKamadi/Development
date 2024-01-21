/*	Problem Statement
 	Daniel has 3.5 apples and Amber has 2.5 apples.
  How many apples do Daniel and Amber have together?
 */

public class VariableClass2 {
    public  static void main(String []args)
    {
        float danialApples = 3.5f;  // for Denial Apples count
        float amberApples  = 2.5f;  // for Amber Apples count

        /*
         * Together Danial and Amber has the following total apples
         */
        float totalApples = danialApples+amberApples;
        System.out.print("Total Apples : "+(int)totalApples);
    }

}
