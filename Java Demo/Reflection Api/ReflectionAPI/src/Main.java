import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("1) Add\n2) Sub\n3) Show");
                System.out.println("Choose the option");
                int choice = sc.nextInt();
                QuizOperationService.performOperation(choice);
            }
            catch (NullPointerException e)
            {
                System.out.println("Enter valid choice");
            }
            catch (InputMismatchException e)
            {
                System.out.println("Enter proper number");
            }


        
    }
}

class InvalidChoiceException extends NullPointerException
{
    public InvalidChoiceException(String str)
    {
        super(str);
    }
}