/* Problem Statement
    write a program to check if two strings are rotations of each other
 */
import java.util.*;
public class StringRotation {
    public static void main(String[] args) {
        // try with resource
        try(Scanner sc = new Scanner(System.in))
        {
            // receive the input1
            String string1 = sc.nextLine();
            // receive the input2
            String string2 = sc.nextLine();

            // lambda expression to check weather rotation of each other
            StringRotationInterface stringRotationInterface = (str1,str2)->
            {
                // if matched then return true else return false
                return (str1+str1).indexOf(str2)!=-1;
            };

            // if matched
            if(stringRotationInterface.isRotation(string1,string2))
                System.out.println("Rotation of each other");
            else
                System.out.println("Not rotation of each other");
        }

        }
}

@FunctionalInterface
interface StringRotationInterface
{
    boolean isRotation(String str1,String str2);
}
