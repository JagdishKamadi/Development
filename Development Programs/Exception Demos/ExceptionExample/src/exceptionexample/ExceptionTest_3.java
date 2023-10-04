/*
  Try With Resources
  
 */
package exceptionexample;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionTest_3 {
    public static void main(String []args)
    {
        File file = new File("Not_Existing_File.txt");
         /* It will automatically delete the object once the work done */
        try(FileInputStream stream = new FileInputStream(file))
        {
            System.out.println("File");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            
        }
    }
}
