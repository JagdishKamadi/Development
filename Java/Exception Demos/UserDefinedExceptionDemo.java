import java.util.Scanner;

public class UserDefinedExceptionDemo {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int age = sc.nextInt();
            if (age < 10) {
                throw new invalidAgeException();
            }
            System.out.println("passed");
        } catch (invalidAgeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Working fine");
        }
        System.out.println("Am I really working? outside of all block");
    }
}

class invalidAgeException extends Exception {
    invalidAgeException() {
        super("Invalid age!");
    }

    invalidAgeException(String str) {
        super(str);
    }
}
