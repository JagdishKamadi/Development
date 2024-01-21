package file_operation;

import java.io.*;
import java.util.Scanner;

public class FileReaderTest {
    public static void main(String[] args) {
        String filePath = "D:/Jagdish/Development/Java Demo/File Demo/file-demo1/src/file_operation/config.txt";

        /**
         * There are different number of ways to read the file
         * we are going to cover some of them
         */

        // 1
        // We are reading the line by line here
        System.out.println("Reading line by line...");
        try (FileReader fileReader = new FileReader(filePath)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getCause());
        }

        //2
        System.out.println("Reading the character by character...");
        try (FileReader fileReader = new FileReader(filePath)) {

            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.println((char) character);
            }

        } catch (IOException e) {
            System.out.println(e.getCause());
        }

        //3

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
