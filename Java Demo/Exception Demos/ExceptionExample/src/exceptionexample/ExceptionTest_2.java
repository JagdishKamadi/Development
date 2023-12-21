/*
 Example of Checked Exception
*/
package exceptionexample;
import java.util.*;
import java.io.*;

public class ExceptionTest_2  {
    public static void main(String args[])
    {
        File file = new File("Not_Existing_File.txt");
        FileInputStream input;
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        }
       
    }
}
