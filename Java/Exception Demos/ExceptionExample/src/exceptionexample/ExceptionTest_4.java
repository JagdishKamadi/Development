/*
*  throws keyword
* throws keyword we use to supress the error but not to handle
 */
package exceptionexample;
import java.util.*;
import java.io.*;

public class ExceptionTest_4 {
    public static void main(String []args) throws Exception
    {
        File file = new File("File_Not_Exist.txt");
        try {
            FileInputStream stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception");
        }
    }
}
